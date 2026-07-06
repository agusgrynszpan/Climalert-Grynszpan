package ar.edu.utn.frba.ddsi.donaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClimaAPIResponse {

    private Current current;

    @Getter
    @Setter
    public static class Current {

        @JsonProperty("temp_c")
        private Double temperatura;

        private Integer humedad;
    }
}
