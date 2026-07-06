package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000)
    public void actualizarClima() {
        climaService.actualizarClima();
    }
}
