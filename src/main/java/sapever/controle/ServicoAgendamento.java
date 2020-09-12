package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sapever.util.VerificadorUtil;

@Service
@RequiredArgsConstructor
public class ServicoAgendamento {
    final ServicoVerificacao servicoVerificacao;
    final ServicoPersistencia servicoPersistencia;

    final VerificadorUtil verificadorUtil;
    final int INTERVALO = 3_000;

    @Scheduled(fixedDelay = INTERVALO)
    void verificar() {
        servicoVerificacao.verificar()
                .forEach(servicoPersistencia::gravarPendencia);
    }
}
