package br.com.state.service;

import br.com.state.converter.StateConverter;
import br.com.state.exception.BusinessException;
import br.com.state.exception.NotFoundException;
import br.com.state.model.State;
import br.com.state.repository.StateRepository;
import br.com.state.request.StateRequest;
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

}
