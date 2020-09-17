package sapever.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sapever.json.PendenciaJson;
import sapever.modelo.Etapa;
import sapever.modelo.Pendencia;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.Repo;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeradorPendencias {
    final Repo repo;
    final RepoTipoPendencia repoTipoPendencia;
    final RepoEtapa repoEtapa;

    public List<PendenciaJson> gerarPendencias() {
        List<PendenciaJson> ps = new ArrayList<>();
        int num = Gerador.gerarInteiro(0, 15);
        for (int i = 0; i <= num; i++) {
            ps.add(new PendenciaJson()
                    .setCodigo(Gerador.gerarInteiro(1, 55))
                    .setDescricao(Gerador.faker.gameOfThrones().house())
                    .setDetalhamento((Gerador.faker.gameOfThrones().quote()))
            );
        }
        return ps;
    }

    public Pendencia gerarPendencia(Etapa etapa) {
        TipoPendencia tipo = Gerador.faker.options().nextElement(repo.tiposPendencia(etapa));
        String detalhamento = Gerador.faker.lorem().paragraph();

        return new Pendencia()
                .setTipoPendencia(tipo)
                .setDetalhamento(detalhamento);
    }

    public Pendencia gerarPendencia(Etapa etapa, int cdTipoPendencia) {
        TipoPendencia tipo = repoTipoPendencia.findById(cdTipoPendencia).orElseThrow();
        String detalhamento = Gerador.faker.lorem().paragraph();

        return new Pendencia()
                .setTipoPendencia(tipo)
                .setDetalhamento(detalhamento);
    }

}
