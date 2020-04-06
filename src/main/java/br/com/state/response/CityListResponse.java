package br.com.state.response;

import br.com.state.dto.CityDto;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
public class CityListResponse implements Serializable {

  private static final long serialVersionUID = 5575771220012336060L;

  @ApiModelProperty("Total of cities")
  private Integer totalElements = 0;

  @ApiModelProperty(value = "City list")
  private List<CityDto> cities = new ArrayList<>();

  public CityListResponse() {
  }

  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public List<CityDto> getCities() {
    return cities;
  }

  public void setCities(List<CityDto> cities) {
    this.cities = cities;
  }


  public static final class CityListResponseBuilder {

    public Integer totalElements = 0;
    public List<CityDto> cities = new ArrayList<>();

    private CityListResponseBuilder() {
    }

    public static CityListResponseBuilder builder() {
      return new CityListResponseBuilder();
    }

    public CityListResponseBuilder totalElements(Integer totalElements) {
      this.totalElements = totalElements;
      return this;
    }

    public CityListResponseBuilder cities(List<CityDto> cities) {
      this.cities = cities;
      return this;
    }

    public CityListResponse build() {
      CityListResponse cityListResponse = new CityListResponse();
      cityListResponse.setTotalElements(totalElements);
      cityListResponse.setCities(cities);
      return cityListResponse;
    }

  }

}
