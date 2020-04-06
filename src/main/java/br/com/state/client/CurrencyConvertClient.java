package br.com.state.client;

import br.com.state.dto.DolarCurrencyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

/**
 * @author João Paulo Santarém
 */
@Component
public class CurrencyConvertClient {

  private Logger logger = LoggerFactory.getLogger(CurrencyConvertClient.class);
  @Value("${api.dollar-currency}")
  private String dollarCurrencyUrl;

  public DolarCurrencyDto getDolarCurrency() {
    final Map<String, Double> result = WebClient.create(dollarCurrencyUrl)
        .get()
        .uri(uriBuilder -> uriBuilder
            .queryParam("q", "USD_BRL")
            .queryParam("compact", "ultra")
            .queryParam("apiKey", "bde9b3734a2d57693731")
            .build()
        )
        .retrieve()
        .bodyToMono(Map.class)
        .block();
    return new DolarCurrencyDto(result);
  }

}
