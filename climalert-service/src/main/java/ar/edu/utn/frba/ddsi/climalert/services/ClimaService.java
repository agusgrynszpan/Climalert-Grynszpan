package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.dto.ClimaAPIClient;
import ar.edu.utn.frba.ddsi.climalert.dto.ClimaAPIResponse;
import ar.edu.utn.frba.ddsi.climalert.models.entities.ClimaRecord;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.ClimaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClimaService {

    private final ClimaAPIClient apiClient;
    private final ClimaRepository repository;

    public ClimaService(ClimaAPIClient apiClient,
                        ClimaRepository repository) {

        this.apiClient = apiClient;
        this.repository = repository;
    }

    public void actualizarClima() {

        ClimaAPIResponse response = apiClient.obtenerClimaActual();

        System.out.println("Temperatura: " + response.getCurrent().getTemperatura());
        System.out.println("Humedad: " + response.getCurrent().getHumedad());

        ClimaRecord clima = new ClimaRecord(
                response.getCurrent().getTemperatura(),
                response.getCurrent().getHumedad(),
                LocalDateTime.now()
        );

       /* ClimaRecord clima = new ClimaRecord(
                40.0,
                80,
                LocalDateTime.now()
        );*/

        repository.guardar(clima);
    }
}
