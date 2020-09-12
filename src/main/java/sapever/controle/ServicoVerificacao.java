package sapever.controle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.modelo.repo.RepoZona;
import sapever.util.VerificadorUtil;
import sapever.verificadores.Verificador;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicoVerificacao {
    final RepoEtapa repoEtapa;
    final RepoTipoPendencia repoTipoPendencia;
    final RepoZona repoZona;
    final VerificadorUtil verificadorUtil;

    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar(TipoPendencia tipoPendencia) {
        Verificador verificador = verificadorUtil.obterVerificador(tipoPendencia);
        return verificadorUtil.etapasAtivas().parallelStream()
                .map(verificador::verificar)
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas da etapa especificada
     **/
    public Stream<Pendencia> verificar(TipoPendencia tipoPendencia, Etapa etapa) {
        Verificador verificador = verificadorUtil.obterVerificador(tipoPendencia);
        return verificadorUtil.zonasTurnoAtual().parallelStream()
                .map(zona -> verificador.verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica todos os tipos de pendências na zona e etapa especificadas
     **/
    public Stream<Pendencia> verificar(Zona zona, Etapa etapa)  {
        return etapa.getTiposPendencias().parallelStream()
                .map(tipoPendencia -> verificadorUtil.obterVerificador(tipoPendencia).verificar(zona, etapa))
                .flatMap(Optional::stream);
    }

    /**
     * Verifica o tipo de pendência especificado na zona e etapa especificadas
     **/
    public Optional<Pendencia> verificar(TipoPendencia tipoPendencia, Zona zona, Etapa etapa)  {
        return verificadorUtil.obterVerificador(tipoPendencia).verificar(zona, etapa);
    }

    /**
     * Verifica o tipo de pendência especificado em todas as zonas e todas as etapas ativas
     **/
    public Stream<Pendencia> verificar() {
        var etapasAtivas = verificadorUtil.etapasAtivas();
        log.info("Iniciando verificação das etapas {}", etapasAtivas);
        etapasAtivas.forEach(etapa -> System.out.println(etapa.getTiposPendencias()));

        return etapasAtivas.stream()
                .flatMap(etapa -> etapa.getTiposPendencias().parallelStream())
                .map(verificadorUtil::obterVerificador)
                .map(Verificador::verificar)
                .flatMap(Optional::stream);
    }

}