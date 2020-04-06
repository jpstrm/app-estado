package br.com.state.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
@Table(name = "CIDADE")
@Entity
public class City extends AbstractModel implements Serializable {

  private static final long serialVersionUID = -3725553877156053084L;

  private String name;

  private Long population;

  @ManyToOne(optional = false)
  @JoinColumn(name = "state_id", referencedColumnName = "id", nullable = false)
  @JsonIgnoreProperties("cities")
  private State state;

  public City() {
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

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "{\"City\":{"
        + "\"name\":\"" + name + "\""
        + ", \"population\":\"" + population + "\""
        + ", \"state\":" + state
        + "}}";
  }

}
