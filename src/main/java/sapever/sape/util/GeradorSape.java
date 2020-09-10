package sapever.sape.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sapever.json.PendenciaJson;
import sapever.json.ZonaJson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeradorSape {
    final Gerador gerador;

    public List<PendenciaJson> gerarPendencias() {
        List<PendenciaJson> ps = new ArrayList<>();
        int num = gerador.gerarInteiro(0, 15);
        for (int i = 0; i <= num; i++) {
            ps.add(new PendenciaJson()
                    .setCodigo(gerador.gerarInteiro(1, 55))
                    .setDescricao(gerador.faker().gameOfThrones().house())
                    .setDetalhamento((gerador.faker().gameOfThrones().quote()))
            );
        }
        return ps;
    }

    List<ZonaJson> gerarZonas() {
        return Collections.emptyList();
    }

    List<ZonaJson> gerarMunicipios() {
        return Collections.emptyList();
    }

    private String gerarDataHoraRecente() {
        return LocalDateTime.now().minusDays(gerador.gerarInteiro(0, 3))
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    ZonaJson gerarZona() {
        String dataHoraUltAtualizacao = gerarDataHoraRecente();
        return ZonaJson.builder()
                .andamento(gerador.gerarInteiro(1, 5))
                .numero(gerador.gerarInteiro(1, 122))
                .numPolo(gerador.gerarInteiro(1, 18))
                .conferente(gerador.gerarNome())
                .dataConferencia(dataHoraUltAtualizacao)
                .dataUltimaAtualizacao(dataHoraUltAtualizacao)
                .pendencias(gerarPendencias())
                .build();
    }

}
