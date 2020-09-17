package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoAnalise {
    OK("Conferida OK"),
    PENDENTE("Conferida, com problemas pendentes"),
    ANALISANDO("Em processo de conferência"),
    NAO_CONFERIDA("Não conferida");

    final String descricao;
}
