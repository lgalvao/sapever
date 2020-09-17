package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.Zona;

import java.util.Optional;

@Slf4j
@ConfigPendencia(numero = 3)
public class QuantitativosDivergentes implements Verificador {
    public Optional<Pendencia> verificar(Zona zona, Etapa etapa) {
        log.info("Verificando pendência {}", codigo());
        return Optional.empty();
    }
}
