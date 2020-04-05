package br.com.estado.response;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class CityResponse implements Serializable {

  public static final long serialVersionUID = -8120273117789320479L;

  @ApiModelProperty(value = "City name", example = "Porto Alegre")
  @NotBlank
  public String name;

  @ApiModelProperty(value = "Population", example = "100000")
  @NotNull
  public Long population;

  @ApiModelProperty(value = "State id", example = "1")
  @NotNull
  public Long stateId;

  public CityResponse() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public Long getStateId() {
    return stateId;
  }

  public void setStateId(Long stateId) {
    this.stateId = stateId;
  }

  @Override
  public String toString() {
    return "{\"CityResponse\":{"
        + "\"name\":\"" + name + "\""
        + ", \"population\":\"" + population + "\""
        + ", \"stateId\":\"" + stateId + "\""
        + "}}";
  }

}
