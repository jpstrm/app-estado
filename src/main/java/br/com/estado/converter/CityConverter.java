package br.com.estado.converter;

import br.com.estado.dto.CityDto;
import br.com.estado.model.City;
import br.com.estado.response.CityListResponse;
import br.com.estado.response.CityListResponse.CityListResponseBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author João Paulo Santarém
 */
@Component
public class CityConverter extends DefaultConverter<City, CityDto> {

  public CityListResponse toListResponse(final List<City> cities) {
    final List<CityDto> citiesDto = cities.stream()
        .map(this::toDto)
        .collect(Collectors.toList());

    return CityListResponseBuilder.builder()
        .totalElements(citiesDto.size())
        .cities(citiesDto)
        .build();
  }

}
