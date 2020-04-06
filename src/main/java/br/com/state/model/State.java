package br.com.state.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Table(name = "ESTADO")
@Entity
public class State extends AbstractModel implements Serializable {

  private static final long serialVersionUID = -2951508584736279246L;

  private String name;

  private String code;

  private String flagUrl;

  @Transient
  private Long population;

  @Transient
  private BigDecimal populationCost;

  @OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
  @JsonIgnoreProperties("state")
  public List<City> cities = new ArrayList<>();

  public State() {
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

  public String getFlagUrl() {
    return flagUrl;
  }

  public void setFlagUrl(String flagUrl) {
    this.flagUrl = flagUrl;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public BigDecimal getPopulationCost() {
    return populationCost;
  }

  public void setPopulationCost(BigDecimal populationCost) {
    this.populationCost = populationCost;
  }

  public List<City> getCities() {
    return cities;
  }

  public void setCities(List<City> cities) {
    this.cities = cities;
  }

  @Override
  public String toString() {
    return "{\"State\":"
        + super.toString()
        + ", \"name\":\"" + name + "\""
        + ", \"code\":\"" + code + "\""
        + ", \"flagUrl\":\"" + flagUrl + "\""
        + ", \"population\":\"" + population + "\""
        + ", \"populationCost\":\"" + populationCost + "\""
        + "}";
  }

}
