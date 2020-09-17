package sapever.verificadores;

import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.Zona;

import java.util.Optional;

public interface Verificador {
    Optional<Pendencia> verificar(Zona zona, Etapa etapa);

    default int codigo() {
        return this.getClass().getAnnotation(ConfigPendencia.class).numero();
    }
}
