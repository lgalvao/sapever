package sapever.controle;

import java.util.Optional;

public interface VerificadorPendencia {
    Optional<TipoPendencia> verificar();
}
