package sapever.json;

import lombok.Data;

@Data
//TODO padronizar nomes. Aqui data está por extenso 'data'; em outros locais está 'dt'
public class EtapaJson {
	private Integer codigo;
	private String descricao;
	// TODO Aqui é data ou data/hora?
	private String dataAtualizacao;
}
