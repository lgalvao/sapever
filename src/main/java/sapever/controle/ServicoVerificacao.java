package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sapever.config.Configuracao;
import sapever.modelo.Etapa;
import sapever.modelo.RepoEtapa;

@Service
@RequiredArgsConstructor
//TODO injetar o intervalo como configuração do sistema
public class ServicoVerificacao {
    final RepoEtapa repoEtapa;
    final Verificadores verificadores;
    final Configuracao configuracao;

    // Intervalo de espera para reiniciar a verificação
    final int INTERVALO = 3_000;

    @Scheduled(fixedDelay = INTERVALO)
    void verificar() {
        configuracao.getEtapasAtivas().forEach(idEtapa -> {
            Etapa etapa = repoEtapa.findById(idEtapa).orElseThrow();
            etapa.getTiposPendencias().parallelStream()
                    .forEach(tipoPendencia -> verificadores.obterVerificador(tipoPendencia).verificar());
        });
    }
}
