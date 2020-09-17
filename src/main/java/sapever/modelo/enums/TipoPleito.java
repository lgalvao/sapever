package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPleito {
    GERAL("Eleição Geral"),
    MUNICIPAL("Eleição Municipal");

    final String descricao;
}
