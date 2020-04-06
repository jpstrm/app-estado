package br.com.state.converter;

import br.com.state.dto.CityDto;
import br.com.state.model.City;
import br.com.state.model.State;
import br.com.state.request.CityListRequest;
import br.com.state.request.CityRequest;
import br.com.state.response.CityListResponse;
import br.com.state.response.CityListResponse.CityListResponseBuilder;
import br.com.state.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author João Paulo Santarém
 */
@Component
public class CityConverter extends DefaultConverter<City, CityDto> {

  @PostConstruct
  private void setup() {
    setClazz(City.class);
    setDtoClazz(CityDto.class);
  }

  @Autowired
  private StateService stateService;

  public City fromRequest(CityRequest cityRequest) {
    final State state = stateService.findById(cityRequest.getStateId());
    final City city = toAny(cityRequest, City.class);
    city.setState(state);

    return city;
  }

  public List<City> fromListRequest(CityListRequest cityListRequest) {
    return cityListRequest.getCities().stream()
        .map(this::fromRequest)
        .collect(Collectors.toList());
  }

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
