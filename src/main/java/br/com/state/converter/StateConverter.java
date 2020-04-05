package br.com.state.converter;

import br.com.state.dto.StateDto;
import br.com.state.model.State;
import br.com.state.request.StateRequest;
import br.com.state.response.StateListResponse;
import br.com.state.response.StateListResponse.StateListResponseBuilder;
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
