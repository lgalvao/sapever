package sapever.json;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PendenciaJson {
    Integer codigo;
    String descricao;
    String detalhamento;
}