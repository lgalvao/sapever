package sapever.modelo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPontoTransmissaoRemota {
    PAE("Posto de Atendimento ao Eleitor"),
    PAT("Ponto Alternativo de Transmissão");

    final String descricao;
}
