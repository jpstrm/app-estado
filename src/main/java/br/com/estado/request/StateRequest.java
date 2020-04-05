package br.com.estado.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class StateRequest implements Serializable {

  public static final long serialVersionUID = 3406477418407553166L;

  @ApiModelProperty(value = "State name", example = "Rio Grande do Sul")
  @NotBlank
  public String name;

  @ApiModelProperty(value = "State code", example = "RS")
  @NotBlank
  public String code;

  public StateRequest() {
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

  @Override
  public String toString() {
    return "{\"StateRequest\":{"
        + "\"name\":\"" + name + "\""
        + ", \"code\":\"" + code + "\""
        + "}}";
  }

}
