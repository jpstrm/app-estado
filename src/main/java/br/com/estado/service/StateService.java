package br.com.estado.service;

import br.com.estado.converter.StateConverter;
import br.com.estado.exception.BusinessException;
import br.com.estado.exception.NotFoundException;
import br.com.estado.model.State;
import br.com.estado.repository.StateRepository;
import br.com.estado.request.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class StateService {

  @Autowired
  private StateRepository stateRepository;

  @Autowired
  private StateConverter stateConverter;

  public List<State> findAll() {

    return stateRepository.findAll();
  }

  public State findById(final Long id) {
    return stateRepository.findById(id)
        .orElseThrow(this::notFoundException);
  }

  private NotFoundException notFoundException() {
    throw new NotFoundException("State not found.");
  }

  public void save(final StateRequest stateRequest) {
    if (stateRepository.existsByName(stateRequest.getName())) {
      throw new BusinessException("There is already a State with this name.");
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

}
