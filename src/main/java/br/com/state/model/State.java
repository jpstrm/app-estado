package br.com.state.model;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
@Entity
public class State extends AbstractModel implements Serializable {

  private static final long serialVersionUID = -2951508584736279246L;

  private String name;

  private String code;

  @Transient
  private String population;

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

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "{\"State\":"
        + super.toString()
        + ", \"name\":\"" + name + "\""
        + ", \"code\":\"" + code + "\""
        + ", \"population\":\"" + population + "\""
        + "}";
  }

}
