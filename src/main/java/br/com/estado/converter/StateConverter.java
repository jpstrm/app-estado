package br.com.estado.converter;

import br.com.estado.dto.CityDto;
import br.com.estado.dto.StateDto;
import br.com.estado.model.City;
import br.com.estado.model.State;
import br.com.estado.request.StateRequest;
import br.com.estado.response.StateListResponse;
import br.com.estado.response.StateListResponse.StateListResponseBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author João Paulo Santarém
 */
@Component
public class StateConverter extends DefaultConverter<State, StateDto> {

  @PostConstruct
  private void setup() {
    setClazz(State.class);
    setDtoClazz(StateDto.class);
  }

  public State fromRequest(final StateRequest stateRequest) {
    return toAny(stateRequest, State.class);
  }

  public StateListResponse toListResponse(final List<State> states) {
    final List<StateDto> stateDtos = states.stream()
        .map(this::toDto)
        .collect(Collectors.toList());

    return StateListResponseBuilder.builder()
        .totalElements(stateDtos.size())
        .states(stateDtos)
        .build();
  }

}
