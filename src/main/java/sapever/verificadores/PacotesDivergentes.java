package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.modelo.Etapa;
import sapever.modelo.Zona;

import java.util.Optional;

@Slf4j
@ConfigPendencia(codigo = 28)
public class PacotesDivergentes implements Verificador {
    public Optional<sapever.modelo.Pendencia> verificar(Zona zona, Etapa etapa) {
        log.info("Verificando pendência {}", codigo());
        return Optional.empty();
    }
}
