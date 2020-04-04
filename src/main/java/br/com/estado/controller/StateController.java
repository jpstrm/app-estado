package br.com.estado.controller;

import br.com.estado.controller.swagger.StateApi;
import br.com.estado.converter.StateConverter;
import br.com.estado.model.State;
import br.com.estado.response.StateListResponse;
import br.com.estado.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@RestController
@RequestMapping("/states")
public class StateController implements StateApi {

  private Logger logger = LoggerFactory.getLogger(StateController.class);

  @Autowired
  private StateService stateService;

  @Autowired
  private StateConverter stateConverter;

  @Override
  @GetMapping
  public ResponseEntity<StateListResponse> findAll() {
    logger.info("GET /states");
    final List<State> states = stateService.findAll();
    final StateListResponse response = stateConverter.toListResponse(states);
    logger.info("Response GET /states - size: {}", response.getTotalElements());

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
