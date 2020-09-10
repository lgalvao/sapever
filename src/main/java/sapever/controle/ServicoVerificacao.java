package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//TODO injetar o intervalo como configuração do sistema
public class ServicoVerificacao {
    final RepoEtapa repoEtapa;
    final FabricaVerificador fabricaVerificador;

    // Intervalo de espera para reiniciar a verificação
    final int INTERVALO = 3_000;

    @Scheduled(fixedDelay = INTERVALO)
    void verificar() {
        // Recuperar etapas ativas
        var etapasAtivas = repoEtapa.findAlllByAtivaIsTrue();

        // Carrregar pendências das etapas ativas
        etapasAtivas.forEach(etapa -> etapa.tipoPendencias.parallelStream()
                .forEach(tipoPendencia -> fabricaVerificador.obterVerificador(tipoPendencia)));

    }

}
