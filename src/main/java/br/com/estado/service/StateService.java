package br.com.estado.service;

import br.com.estado.exception.NotFoundException;
import br.com.estado.model.State;
import br.com.estado.repository.StateRepository;
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

}
