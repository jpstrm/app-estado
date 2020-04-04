package br.com.estado.controller;

import br.com.estado.controller.swagger.CityApi;
import br.com.estado.converter.CityConverter;
import br.com.estado.model.City;
import br.com.estado.response.CityListResponse;
import br.com.estado.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@RestController("/cities")
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

}
