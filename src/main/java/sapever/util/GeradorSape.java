package sapever.util;

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
    public List<PendenciaJson> gerarPendencias() {
        List<PendenciaJson> ps = new ArrayList<>();
        int num = Gerador.gerarInteiro(0, 15);
        for (int i = 0; i <= num; i++) {
            ps.add(new PendenciaJson()
                    .setCodigo(Gerador.gerarInteiro(1, 55))
                    .setDescricao(Gerador.faker().gameOfThrones().house())
                    .setDetalhamento((Gerador.faker().gameOfThrones().quote()))
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
        return LocalDateTime.now().minusDays(Gerador.gerarInteiro(0, 3))
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    ZonaJson gerarZona() {
        String dataHoraUltAtualizacao = gerarDataHoraRecente();
        return ZonaJson.builder()
                .andamento(Gerador.gerarInteiro(1, 5))
                .numero(Gerador.gerarInteiro(1, 122))
                .numPolo(Gerador.gerarInteiro(1, 18))
                .conferente(Gerador.gerarNome())
                .dataConferencia(dataHoraUltAtualizacao)
                .dataUltimaAtualizacao(dataHoraUltAtualizacao)
                .pendencias(gerarPendencias())
                .build();
    }

}
