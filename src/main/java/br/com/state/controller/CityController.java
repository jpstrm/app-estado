package br.com.state.controller;

import br.com.state.controller.swagger.CityApi;
import br.com.state.converter.CityConverter;
import br.com.state.model.City;
import br.com.state.request.CityRequest;
import br.com.state.response.CityListResponse;
import br.com.state.service.CityService;
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
@RequestMapping("/cities")
public class CityController implements CityApi {

  private Logger logger = LoggerFactory.getLogger(CityController.class);

  @Autowired
  private CityService cityService;

  @Autowired
  private CityConverter cityConverter;

  @Override
  @GetMapping
  public ResponseEntity<CityListResponse> findAll() {
    logger.info("GET /cities");
    final List<City> cities = cityService.findAll();
    final CityListResponse response = cityConverter.toListResponse(cities);
    logger.info("Response GET /cities - size: {}", response.getTotalElements());

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @Override
  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody final CityRequest cityRequest) {
    logger.info("POST /cities - {}", cityRequest);
    cityService.save(cityRequest);
    logger.info("POST /cities - {}", cityRequest);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  @PutMapping("/{cityId}")
  public ResponseEntity<Void> update(@PathVariable final Long cityId, @Valid @RequestBody CityRequest cityRequest) {
    logger.info("POST /cities/{} - {}", cityId, cityRequest);
    cityService.update(cityId, cityRequest);
    logger.info("Response POST /cities/{} - {}", cityId, cityRequest);

    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @Override
  @GetMapping("/states/{stateId}")
  public ResponseEntity<CityListResponse> findByStateId(@PathVariable final Long stateId) {
    logger.info("GET /states/{}", stateId);
    final List<City> cities = cityService.findByStateId(stateId);
    final CityListResponse response = cityConverter.toListResponse(cities);
    logger.info("Response GET /states/{} - size: {}", stateId, response.getTotalElements());

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
