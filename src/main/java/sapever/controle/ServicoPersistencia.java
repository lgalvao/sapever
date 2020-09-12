package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sapever.modelo.Pendencia;
import sapever.modelo.repo.RepoPendencia;

@Service
@RequiredArgsConstructor
public class ServicoPersistencia {
    final RepoPendencia repoPendencia;

    public void gravarPendencia(Pendencia pendencia) {
        repoPendencia.save(pendencia);
    }
}
