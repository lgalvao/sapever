package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoVerificacao {
    NV("Não será verificada"),
    ATIVA("Verificação ativa"),
    INATIVA("Verificação inativa");

    final String descricao;
}
