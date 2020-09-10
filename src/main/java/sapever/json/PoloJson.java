package sapever.json;

import lombok.Data;

import java.util.List;

@Data
public class PoloJson {
    Integer numero;
    Integer andamento;
    String municipioSede;
    String periodoEtapa;
    String situacaoVerificacao;
    String dataUltimaAtualizacao;
    Integer itensTotais;
    Integer itensRestantes;
    Double percRealizado;
    List<SuporteTecnologicoJson> sts;
    List<PendenciaJson> pendencias;
}