package sapever.json;

import lombok.Data;

import java.util.List;

@Data
public class MunicipioJson {
    Integer codIbge;
    Integer codTse;
    String nome;
    Integer numPolo;
    String periodoEtapa;
    String situacaoVerificacao;
    Integer andamento;
    Double percRealizado;
    Integer itensTotais;
    Integer itensRestantes;
    String dataUltimaAtualizacao;
    // TODO talvez fique melhor criar um objeto com as info completas de Transm. remota em vez de ter três campos aqui
    TransmissaoRemotaJson transRemota;
    Boolean sedePtr;
    PontoTransmissaoRemotaJson pontoTr;
    String situacaoRelatorios;
    List<DetalheRelatorioJson> detRelatorios;
    List<SuporteTecnologicoJson> sts;
}