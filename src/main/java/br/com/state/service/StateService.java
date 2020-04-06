package br.com.state.service;

import br.com.state.client.CurrencyConvertClient;
import br.com.state.converter.StateConverter;
import br.com.state.dto.DolarCurrencyDto;
import br.com.state.exception.BusinessException;
import br.com.state.exception.NotFoundException;
import br.com.state.model.City;
import br.com.state.model.State;
import br.com.state.repository.StateRepository;
import br.com.state.request.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

/**
 * @author João Paulo Santarém
 */
@Service
public class StateService {

  @Autowired
  private StateRepository stateRepository;

  @Autowired
  private StateConverter stateConverter;

  @Autowired
  private CurrencyConvertClient currencyConvertClient;

  @Value("${app.cost.cost-per-citizen-in-dollar}")
  private BigDecimal costPerCitizenInDollar;

  @Value("${app.cost.discount-above}")
  private Long discountAbovePopulationNum;

  @Value("${app.cost.discount-value}")
  private BigDecimal discountValue;

  public List<State> findAll() {
    return stateRepository.findAll().stream()
        .peek(s -> {
          s.setPopulation(getPopulation(s));
          s.setPopulationCost(getPopulationCost(s));
        })
        .collect(Collectors.toList());
  }

  public State findById(final Long id) {
    return stateRepository.findById(id)
        .orElseThrow(this::notFoundException);
  }

  private NotFoundException notFoundException() {
    throw new NotFoundException("Estado não encontrado.");
  }

  public void save(final StateRequest stateRequest) {
    if (stateRepository.existsByName(stateRequest.getName())) {
      throw new BusinessException("Já existe um Estado com esse nome.");
    }
    State state = stateConverter.fromRequest(stateRequest);
    stateRepository.save(state);
  }

  public void update(final Long id, final StateRequest stateRequest) {
    State state = findById(id);
    state.setName(stateRequest.getName());
    state.setCode(stateRequest.getCode());

    stateRepository.save(state);
  }

  private Long getPopulation(final State state) {

    return state.getCities().stream()
        .map(City::getPopulation)
        .reduce(0L, Long::sum);

  }

  private BigDecimal getPopulationCost(final State s) {
    final BigDecimal unitCostInBrl = this.getCostInBrl();

    final BigDecimal totalCost = unitCostInBrl
        .multiply(costPerCitizenInDollar)
        .multiply(BigDecimal.valueOf(s.getPopulation()));

    BigDecimal totalDiscount = getTotalDiscount(s, totalCost);

    return totalCost.subtract(totalDiscount)
        .setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal getCostInBrl() {
    BigDecimal brlValue = BigDecimal.ONE;
    final DolarCurrencyDto dolarCurrencyDto = currencyConvertClient.getDolarCurrency();
    if (nonNull(dolarCurrencyDto) && nonNull(dolarCurrencyDto.getBrlValue())) {
      brlValue = dolarCurrencyDto.getBrlValue();
    }

    return brlValue;
  }

  private BigDecimal getTotalDiscount(final State s, final BigDecimal totalCost) {
    if (s.getPopulation() > discountAbovePopulationNum) {
      return totalCost.multiply(discountValue)
          .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    return BigDecimal.ZERO;
  }

}
