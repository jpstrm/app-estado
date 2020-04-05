package br.com.state.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class StateDto implements Serializable {

  private static final long serialVersionUID = -3378095194869217644L;

  @ApiModelProperty(value = "State id", example = "1")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long id;

  @ApiModelProperty(value = "State name", example = "Rio Grande do Sul")
  @NotBlank
  public String name;

  @ApiModelProperty(value = "State code", example = "RS")
  @NotBlank
  public String code;

  @ApiModelProperty(value = "Population", example = "3000000")
  @NotNull
  public Long population;

  public StateDto() {
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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "{\"StateDto\":{"
        + "\"id\":\"" + id + "\""
        + ", \"name\":\"" + name + "\""
        + ", \"code\":\"" + code + "\""
        + ", \"population\":\"" + population + "\""
        + "}}";
  }

}
