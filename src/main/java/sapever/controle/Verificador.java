package sapever.controle;

import sapever.modelo.TipoPendencia;

import java.util.Optional;

public interface Verificador {
    Optional<TipoPendencia> verificar();
}
