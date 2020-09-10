package sapever.json;

import lombok.Data;

//TODO as datas podem ser do tipo correto; é só definir a formatação com uma anotação
@Data
public class EstatisticaConferenciaJson {
	Integer ordem;
	Integer zona;
	String dtAptaConferencia;
	Integer tempoEspera;
	String conferente;
	String dtConferenciaIniciada;
	String dtConferenciaFinalizada;
	Integer tempoConferencia;
}