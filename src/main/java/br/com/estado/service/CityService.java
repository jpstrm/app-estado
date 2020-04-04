package br.com.estado.service;

import br.com.estado.model.City;
import br.com.estado.repository.CityRepository;
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

  public List<City> findAll() {

    return cityRepository.findAll();
  }

}
