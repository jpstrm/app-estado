package br.com.state.dto;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author João Paulo Santarém
 */
public class DolarCurrencyDto {

  private Map<String, Double> result;

  private BigDecimal brlValue;

  public DolarCurrencyDto() {
  }

  public DolarCurrencyDto(Map<String, Double> result) {
    this.result = result;
  }

  public void setBrlValue(BigDecimal brlValue) {
    this.brlValue = brlValue;
  }

  public BigDecimal getBrlValue() {
    return BigDecimal.valueOf(this.result.get("USD_BRL"));
  }

}
