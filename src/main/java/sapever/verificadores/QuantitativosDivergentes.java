package sapever.verificadores;

import lombok.extern.slf4j.Slf4j;
import sapever.controle.Verificador;
import sapever.modelo.Etapa;
import sapever.modelo.Zona;

import java.util.Optional;

@Slf4j
@ConfigPendencia(codigo = 3)
public class QuantitativosDivergentes implements Verificador {
    @Override
    public Optional<sapever.modelo.Pendencia> verificar(Zona zona, Etapa etapa) {
        return Optional.empty();
    }
}
