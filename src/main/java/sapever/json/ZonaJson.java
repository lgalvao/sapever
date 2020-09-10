
package sapever.json;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ZonaJson {
    Integer numero;
    Integer numPolo;
    Integer andamento;
    String municipioSede;
    String periodoEtapa;
    String situacaoVerificacao;
    String dataUltimaAtualizacao;
    Double percRealizado;
    Integer itensTotais;
    Integer itensRestantes;
    String situacaoConferencia;
    String dataConferencia;
    String conferente;
    String obsConferencia;

    //TODO Infos de atas ficaram confusas. Entender e documentar
    String situacaoAta;
    String dataGeracaoAta;
    List<DetalheAtaJson> detAta;

    //TODO Idem para relatórios. Entender e documentar
    String situacaoRelatorios;
    List<DetalheRelatorioJson> detRelatorios;

    List<HistoricoConferenciaJson> histConferencias;
    List<SuporteTecnologicoJson> sts;
    List<PendenciaJson> pendencias;
}