package br.com.state.controller;

import br.com.state.controller.swagger.StateApi;
import br.com.state.converter.StateConverter;
import br.com.state.model.State;
import br.com.state.request.StateRequest;
import br.com.state.response.StateListResponse;
import br.com.state.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

  @Override
  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody final StateRequest stateRequest) {
    logger.info("POST /states - {}", stateRequest);
    stateService.save(stateRequest);
    logger.info("POST /states - {}", stateRequest);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  @PutMapping("/{stateId}")
  public ResponseEntity<Void> update(@PathVariable final Long stateId, @Valid @RequestBody StateRequest stateRequest) {
    logger.info("POST /states/{} - {}", stateId, stateRequest);
    stateService.update(stateId, stateRequest);
    logger.info("Response POST /states/{} - {}", stateId, stateRequest);

    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
