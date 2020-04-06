package br.com.state.service;

import br.com.state.converter.CityConverter;
import br.com.state.exception.BusinessException;
import br.com.state.exception.NotFoundException;
import br.com.state.model.City;
import br.com.state.repository.CityRepository;
import br.com.state.request.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    if (cityRepository.existsByNameAndStateId(cityRequest.getName(), cityRequest.getStateId())) {
      throw new BusinessException("Já existe uma Cidade para o Estado selecionado.");
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

  public List<City> findByStateId(final Long stateId) {
    if (cityRepository.existsByStateId(stateId)) {
      return cityRepository.findAllByStateId(stateId);
    }
    throw new NotFoundException("Cidades não encontradas para o Estado: " + stateId);
  }


  private NotFoundException notFoundException() {
    throw new NotFoundException("Cidade não encontrada.");
  }

}
