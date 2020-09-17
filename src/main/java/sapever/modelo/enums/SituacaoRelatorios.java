package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoRelatorios {
    NA("NA"),
    REL_EMITIDOS("Todos os relatórios emitidos"),
    REL_PARC_EMITIDOS("Relatórios parcialmente emitidos"),
    REL_NAO_EMITIDOS("Relatórios não emitidos");

    final String descricao;
}
