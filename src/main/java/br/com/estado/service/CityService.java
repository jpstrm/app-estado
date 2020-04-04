package br.com.estado.service;

import br.com.estado.converter.CityConverter;
import br.com.estado.exception.BusinessException;
import br.com.estado.exception.NotFoundException;
import br.com.estado.model.City;
import br.com.estado.repository.CityRepository;
import br.com.estado.request.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xnio.conduits.BufferedStreamSinkConduit;

import java.util.List;

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
    if (cityRepository.existsByName(cityRequest.getName())) {
      throw new BusinessException("There is already a city with this name.");
    }
    City city = cityConverter.fromRequest(cityRequest);
    cityRepository.save(city);
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

  public City findByName(final String name) {
    return cityRepository.findByName(name)
        .orElseThrow(this::notFoundException);
  }

  public List<City> findByStateId(final Long stateId) {
    if (!cityRepository.existsByStateId(stateId)) {
      return cityRepository.findAllByStateId(stateId);
    }
    throw new NotFoundException("Cities not found by State id: " + stateId);
  }


  private NotFoundException notFoundException() {
    throw new NotFoundException("City not found");
  }


}
