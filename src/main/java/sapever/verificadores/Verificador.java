package sapever.verificadores;

import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.Zona;

import java.util.Optional;

public interface Verificador {
    /**
     * Verifica o tipo de pendência para todas as zonas de todas as etapas ativas
     **/
    public default Optional<Pendencia> verificar() {
        return Optional.empty();
    }

    /**
     * Verifica o tipo de pendência para todas as zonas da etapa especificada
     **/
    public default Optional<Pendencia> verificar(Etapa etapa) {
        return Optional.empty();
    }

    /**
     * Verifica o tipo de pendência para a zona e etapa especificadas
     **/
    Optional<Pendencia> verificar(Zona zona, Etapa etapa);

    default int codigo() {
        return this.getClass().getAnnotation(ConfigPendencia.class).codigo();
    }
}
