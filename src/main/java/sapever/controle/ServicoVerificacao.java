package sapever.controle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.Repo;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.modelo.repo.RepoZona;
import sapever.util.Contexto;
import sapever.verificadores.Verificador;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicoVerificacao {
    final Repo repo;
    final RepoEtapa repoEtapa;
    final RepoTipoPendencia repoTipoPendencia;
    final RepoZona repoZona;
    final Contexto contexto;

    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar(Etapa etapa, TipoPendencia tipoPendencia) {
        Verificador verificador = contexto.obterVerificador(tipoPendencia);
        return repoZona.todasPleitoAtual().stream()
                .map(zona -> verificador.verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas da etapa especificada
     **/
    public Stream<Pendencia> verificar(TipoPendencia tipoPendencia, Etapa etapa) {
        Verificador verificador = contexto.obterVerificador(tipoPendencia);
        return repo.zonas().parallelStream()
                .map(zona -> verificador.verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica todos os tipos de pendências na zona e etapa especificadas
     **/
    public Stream<Pendencia> verificar(Zona zona, Etapa etapa) {
        return repo.tiposPendencia(etapa).parallelStream()
                .map(tipoPendencia -> contexto.obterVerificador(tipoPendencia).verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado na zona e etapa especificadas
     **/
    public Optional<Pendencia> verificar(TipoPendencia tipoPendencia, Zona zona, Etapa etapa) {
        return contexto.obterVerificador(tipoPendencia).verificar(zona, etapa);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar(Etapa etapa) {
        return repo.tiposPendencia(etapa).stream().flatMap(tipo -> verificar(etapa, tipo));
    }
}