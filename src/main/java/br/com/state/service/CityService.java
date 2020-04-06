package br.com.state.service;

import br.com.state.converter.CityConverter;
import br.com.state.exception.BusinessException;
import br.com.state.exception.NotFoundException;
import br.com.state.model.City;
import br.com.state.repository.CityRepository;
import br.com.state.request.CityListRequest;
import br.com.state.request.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.state.helper.ApiHelper.RIO_GRANDE_DO_SUL_CODE;

/**
 * @author João Paulo Santarém
 */
@Service
public class CityService {

  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private CityConverter cityConverter;

  public List<City> findAll() {

    return cityRepository.findAll();
  }


  public void save(final CityRequest cityRequest) {
    City city = cityConverter.fromRequest(cityRequest);
    validateDuplicated(city.getName(), city.getState().getId(), city.getState().getName());
    cityRepository.save(city);
  }

  public void saveAll(CityListRequest cityListRequest) {
    final List<City> cities = cityConverter.fromListRequest(cityListRequest);
    cities.forEach(c -> validateDuplicated(c.getName(), c.getState().getId(), c.getState().getName()));
    cityRepository.saveAll(cities);
  }

  public void update(final Long id, final CityRequest cityRequest) {
    City city = findById(id);
    city.setName(cityRequest.getName());
    city.setPopulation(cityRequest.getPopulation());

    cityRepository.save(city);
  }

  public City findById(final Long id) {
    return cityRepository.findById(id)
        .orElseThrow(this::notFoundException);
  }

  public List<City> findByStateId(final Long stateId) {
    if (cityRepository.existsByStateId(stateId)) {
      return cityRepository.findAllByStateId(stateId);
    }
    throw new NotFoundException("Cidades não encontradas para o Estado: " + stateId);
  }

  public void deleteById(final Long cityId) {
    final City city = findById(cityId);
    if (city.getState().getCode().equalsIgnoreCase(RIO_GRANDE_DO_SUL_CODE)) {
      throw new BusinessException("Não é possível deletar cidades do estado do Rio Grande do Sul");
    }
    cityRepository.deleteById(cityId);
  }


  private NotFoundException notFoundException() {
    throw new NotFoundException("Cidade não encontrada.");
  }

  private void validateDuplicated(final String cityName, final Long stateId, final String stateName) {
    if (cityRepository.existsByNameAndStateId(cityName, stateId)) {
      throw new BusinessException("Cidade '" + cityName + "' já existe no Estado '" + stateName + "'.");
    }
  }

}
