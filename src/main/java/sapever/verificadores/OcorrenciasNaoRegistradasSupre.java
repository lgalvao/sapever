package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.controle.Verificador;
import sapever.modelo.TipoPendencia;

import java.util.Optional;

@ConfigPendencia(codigo = 1)
@Slf4j
public class OcorrenciasNaoRegistradasSupre implements Verificador {
    @Override
    public Optional<TipoPendencia> verificar() {
        log.info("Verificando pendência 1");
        return Optional.empty();
    }
}
