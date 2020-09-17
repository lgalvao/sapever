package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sapever.modelo.repo.Repo;
import sapever.util.Contexto;

@Service
@RequiredArgsConstructor
public class ServicoAgendamento {
    final ServicoVerificacao servicoVerificacao;
    final ServicoPersistencia servicoPersistencia;
    final Repo repo;

    final Contexto verificadorUtil;
    final int INTERVALO = 3_000;

    @Scheduled(fixedDelay = INTERVALO)
    void verificar() {
        var etapas = repo.etapasAtivas();
        etapas.forEach(etapa ->
                servicoVerificacao.verificar(etapa).forEach(servicoPersistencia::gravarPendencia)
        );
    }
}
