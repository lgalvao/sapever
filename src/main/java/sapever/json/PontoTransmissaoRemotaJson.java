package sapever.json;

import lombok.Data;

@Data
public class PontoTransmissaoRemotaJson {
	private Integer numero;
	private String descricao;
	private String latitude;
	private String longitude;
	private String tipo;
}