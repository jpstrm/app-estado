package br.com.state.response;

import br.com.state.dto.StateDto;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
public class StateListResponse implements Serializable {

  private static final long serialVersionUID = 8232367278499559221L;

  @ApiModelProperty("Total of states")
  public Integer totalElements = 0;

  @ApiModelProperty(value = "State list")
  public List<StateDto> states = new ArrayList<>();

  public StateListResponse() {
  }

  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public List<StateDto> getStates() {
    return states;
  }

  public void setStates(List<StateDto> states) {
    this.states = states;
  }


  public static final class StateListResponseBuilder {

    public Integer totalElements = 0;
    public List<StateDto> states = new ArrayList<>();

    private StateListResponseBuilder() {
    }

    public static StateListResponseBuilder builder() {
      return new StateListResponseBuilder();
    }

    public StateListResponseBuilder totalElements(Integer totalElements) {
      this.totalElements = totalElements;
      return this;
    }

    public StateListResponseBuilder states(List<StateDto> states) {
      this.states = states;
      return this;
    }

    public StateListResponse build() {
      StateListResponse stateListResponse = new StateListResponse();
      stateListResponse.setTotalElements(totalElements);
      stateListResponse.setStates(states);
      return stateListResponse;
    }

  }

  @Override
  public String toString() {
    return "{\"StateListResponse\":{"
        + "\"totalElements\":\"" + totalElements + "\""
        + ", \"states\":" + states
        + "}}";
  }

}
