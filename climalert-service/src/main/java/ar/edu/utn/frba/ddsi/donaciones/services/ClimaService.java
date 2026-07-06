package ar.edu.utn.frba.ddsi.donaciones.services;

import ar.edu.utn.frba.ddsi.donaciones.dto.ClimaAPIClient;
import ar.edu.utn.frba.ddsi.donaciones.dto.ClimaAPIResponse;
import ar.edu.utn.frba.ddsi.donaciones.models.entities.ClimaRecord;
import ar.edu.utn.frba.ddsi.donaciones.models.repositories.ClimaRepository;
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

        ClimaRecord clima = new ClimaRecord(
                response.getCurrent().getTemperatura(),
                response.getCurrent().getHumedad(),
                LocalDateTime.now()
        );

        repository.guardar(clima);
    }
}
