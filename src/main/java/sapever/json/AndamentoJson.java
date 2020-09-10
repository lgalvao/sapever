package sapever.json;

import lombok.Data;

/**
 * Representa um dos andamentos possíveis para uma etapa de verificação
 */
@Data
public class AndamentoJson {
    Integer numero;
    String descricao;
    String cor;
    String detalhamento;
    Boolean destacaPendencias;
}
