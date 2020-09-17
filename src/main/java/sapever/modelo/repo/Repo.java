package sapever.modelo.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sapever.modelo.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Repo {
    final RepoPendencia repoPendencia;
    final RepoZona repoZona;
    final RepoMunicipio repoMunicipio;
    final RepoVerificacoesEtapa repoVerificacoesEtapa;
    final RepoPleito repoPleito;
    final RepoEtapa repoEtapa;

    public Pleito pleitoAtual() {
        return repoPleito.findAllByAtualIsTrue().orElseThrow();
    }

    public List<TipoPendencia> tiposPendencia(Etapa etapa) {
        return repoVerificacoesEtapa.tiposPendencia(pleitoAtual(), etapa);
    }

    public List<VerificacaoEtapa> verificacoesEtapaAtivas() {
        return repoVerificacoesEtapa.verificacaoEtapasAtivas();
    }

    public List<Zona> zonas() {
        return repoZona.todasPleitoAtual();
    }

    public List<Etapa> etapasAtivas() {
        return verificacoesEtapaAtivas().stream().map(VerificacaoEtapa::getEtapa).collect(Collectors.toList());
    }

    public List<Integer> codigosPendenciaEtapa(Etapa etapa) {
        return repoVerificacoesEtapa.tiposPendencia(pleitoAtual(), etapa).stream()
                .map(TipoPendencia::getNumero).collect(Collectors.toList());
    }
}
