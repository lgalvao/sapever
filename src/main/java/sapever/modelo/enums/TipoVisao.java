package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoVisao {
    ZONAS("Visão de Zonas"),
    MUNICIPIOS("Visão de Municípios"),
    POLOS("Visão de Polos");

    final String descricao;
}
