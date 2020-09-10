package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.controle.Verificador;
import sapever.modelo.TipoPendencia;

import java.util.Optional;

@ConfigPendencia(codigo = 3)
@Slf4j
public class QuantitativosDivergentes implements Verificador {
    @Override
    public Optional<TipoPendencia> verificar() {
        log.info("Verificando pendência 3");
        return Optional.empty();
    }
}
