package ar.edu.utn.frba.ddsi.climalert.models.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.ClimaRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ClimaRepository {
    private final List<ClimaRecord> registros = new ArrayList<>();

    public void guardar(ClimaRecord clima) {
        registros.add(clima);
    }

    public ClimaRecord ultimoRegistro() {
        if (registros.isEmpty()) {
            return null;
        }
        return registros.get(registros.size() - 1);
    }

    public List<ClimaRecord> obtenerTodos() {
        return Collections.unmodifiableList(registros);
    }

}
