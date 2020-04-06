package br.com.state.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "City Request")
public class CityRequest implements Serializable {

  public static final long serialVersionUID = 3406477418407553166L;

  @ApiModelProperty(value = "City name", example = "Porto Alegre")
  @NotBlank
  private String name;

  @ApiModelProperty(value = "Population", example = "100000")
  @NotNull
  private Long population;

  @ApiModelProperty(value = "State id", example = "1")
  @NotNull
  private Long stateId;

  public CityRequest() {
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
    return "{\"CityRequest\":{"
        + "\"name\":\"" + name + "\""
        + ", \"population\":\"" + population + "\""
        + ", \"stateId\":\"" + stateId + "\""
        + "}}";
  }

}
