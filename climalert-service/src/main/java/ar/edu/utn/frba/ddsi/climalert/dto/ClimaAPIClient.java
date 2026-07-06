package ar.edu.utn.frba.ddsi.climalert.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ClimaAPIClient {

    private final RestClient restClient = RestClient.create();

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.city}")
    private String ciudad;

    public ClimaAPIResponse obtenerClimaActual() {

        return restClient.get()
                .uri("https://api.weatherapi.com/v1/current.json?key={key}&q={city}",
                        apiKey,
                        ciudad)
                .retrieve()
                .body(ClimaAPIResponse.class);
    }
}
