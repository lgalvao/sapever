package sapever.json;

import lombok.Data;

@Data
//TODO essa etapa como String seria o que? Em outros pontos, é recebida a etapa como inteiro.
public class HistoricoConferenciaJson {
	Integer id;
	String etapa;
	Integer turno;
	String conferente;
	String observacao;
}