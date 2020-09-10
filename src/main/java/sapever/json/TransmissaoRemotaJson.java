package sapever.json;

import lombok.Data;

@Data
public class TransmissaoRemotaJson {
	Double percRealizado;
	Integer itensTotais;
	Integer itensRestantes;
	String dataUltimaAtualizacao;
}
