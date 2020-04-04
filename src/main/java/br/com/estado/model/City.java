package br.com.estado.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
@Entity
public class City implements Serializable {

  private static final long serialVersionUID = -3725553877156053084L;

  private String name;

  private String population;

  @ManyToOne(optional = false)
  @JoinColumn(name = "state_id", referencedColumnName = "id", nullable = false)
  private State state;

  public City() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
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
