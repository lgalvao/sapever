package sapever.controle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sapever.config.Configuracao;
import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.modelo.repo.RepoZona;
import sapever.util.Util;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ServicoVerificacao {
    final RepoEtapa repoEtapa;
    final RepoTipoPendencia repoTipoPendencia;
    final RepoZona repoZona;

    final Configuracao configuracao;
    final Util util;


    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar(TipoPendencia tipoPendencia) {
        Verificador verificador = util.obterVerificador(tipoPendencia);
        return util.etapasAtivas().parallelStream()
                .map(verificador::verificar)
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas da etapa especificada
     **/
    public Stream<Pendencia> verificar(TipoPendencia tipoPendencia, Etapa etapa) {
        Verificador verificador = util.obterVerificador(tipoPendencia);
        return util.zonasTurnoAtual().parallelStream()
                .map(zona -> verificador.verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica todos os tipos de pendências na zona e etapa especificadas
     **/
    public Stream<Pendencia> verificar(Zona zona, Etapa etapa)  {
        return etapa.getTiposPendencias().parallelStream()
                .map(tipoPendencia -> util.obterVerificador(tipoPendencia).verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado na zona e etapa especificadas
     **/
    public Optional<Pendencia> verificar(TipoPendencia tipoPendencia, Zona zona, Etapa etapa)  {
        return util.obterVerificador(tipoPendencia).verificar(zona, etapa);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar() {
        return util.etapasAtivas().stream()
                .flatMap(etapa -> etapa.getTiposPendencias().parallelStream())
                .map(util::obterVerificador)
                .map(Verificador::verificar)
                .flatMap(Optional::stream);
    }

}