package br.com.state.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class CityDto implements Serializable {

  private static final long serialVersionUID = 3731393270402054227L;

  @ApiModelProperty(value = "City id", example = "1")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Long id;

  @ApiModelProperty(value = "City name", example = "Porto Alegre")
  @NotBlank
  private String name;

  @ApiModelProperty(value = "Population", example = "100000")
  @NotNull
  private Long population;

  @ApiModelProperty(value = "State code", example = "RS")
  @NotNull
  private String stateCode;

  @ApiModelProperty(value = "State id", example = "1")
  @NotNull
  private Long stateId;

  public CityDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public Long getStateId() {
    return stateId;
  }

  public void setStateId(Long stateId) {
    this.stateId = stateId;
  }

  @Override
  public String toString() {
    return "{\"CityDto\":{"
        + "\"id\":\"" + id + "\""
        + ", \"name\":\"" + name + "\""
        + ", \"population\":\"" + population + "\""
        + ", \"stateCode\":\"" + stateCode + "\""
        + ", \"stateId\":\"" + stateId + "\""
        + "}}";
  }

}
