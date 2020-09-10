package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.controle.Verificador;
import sapever.modelo.TipoPendencia;

import java.util.Optional;

@ConfigPendencia(codigo = 28)
@Slf4j
public class PacotesDivergentes implements Verificador {
    @Override
    public Optional<TipoPendencia> verificar() {
        log.info("Verificando pendência 28");
        return Optional.empty();
    }
}
