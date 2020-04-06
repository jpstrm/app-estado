package br.com.state.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "City list Request")
public class CityListRequest implements Serializable {

  public static final long serialVersionUID = 2429994766872373000L;

  @ApiModelProperty(value = "List of Cities")
  @Valid
  @NotNull
  private List<CityRequest> cities;

  public CityListRequest() {
  }

  public List<CityRequest> getCities() {
    return cities;
  }

  public void setCities(List<CityRequest> cities) {
    this.cities = cities;
  }

}
