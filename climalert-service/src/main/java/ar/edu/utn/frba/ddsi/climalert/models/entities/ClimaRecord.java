package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ClimaRecord {

    public static final String ubicacion = "CABA";
    private boolean alertaEnviada = false;

    private Double temperatura;
    private Integer humedad;
    private LocalDateTime fechaHora;

    public ClimaRecord(Double temperatura, Integer humedad, LocalDateTime fechaHora) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.fechaHora = fechaHora;
    }

    public boolean hayAlerta() {
        return temperatura > 35 && humedad > 60;
    }

    public void marcarComoNotificada() {
        alertaEnviada = true;
    }
}
