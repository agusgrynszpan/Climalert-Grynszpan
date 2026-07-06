package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.models.entities.ClimaRecord;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarAlerta(ClimaRecord clima) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(
                "admin@clima.com",
                "emergencias@clima.com",
                "meteorologia@clima.com"
        );

        mensaje.setSubject("Alerta meteorológica");

        mensaje.setText("""
                Se detectó una condición climática crítica.

                Ubicación: %s
                Temperatura: %.1f°C
                Humedad: %d%%
                Fecha: %s
                """.formatted(
                ClimaRecord.ubicacion,
                clima.getTemperatura(),
                clima.getHumedad(),
                clima.getFechaHora()));

        mailSender.send(mensaje);
    }
}
