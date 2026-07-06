package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.models.entities.ClimaRecord;
import ar.edu.utn.frba.ddsi.climalert.models.repositories.ClimaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    private final ClimaRepository repository;
    private final EmailService emailService;

    public AlertaService(ClimaRepository repository,
                         EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public void verificarAlerta() {

        ClimaRecord clima = repository.ultimoRegistro();

        if (clima != null &&
                clima.hayAlerta() &&
                !clima.isAlertaEnviada()) {

            emailService.enviarAlerta(clima);

            clima.marcarComoNotificada();
        }
    }
}
