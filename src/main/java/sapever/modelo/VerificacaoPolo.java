package sapever.modelo;

import lombok.Data;
import sapever.modelo.enums.SituacaoVerificacao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VW_SAPE_VERIFICACAO_POLO")
@Data
public class VerificacaoPolo {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_VERIFICACAO_ETAPA", referencedColumnName = "COD_OBJETO")
    VerificacaoEtapa verificacaoEtapa;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_POLO", referencedColumnName = "COD_OBJETO")
    Polo polo;

    @Column(name = "SIT_VERIFICACAO")
    @Enumerated(EnumType.STRING)
    SituacaoVerificacao situacaoVerificacao;

    @Column(name = "DAT_ULT_ATUALIZACAO")
    LocalDateTime dataUltimaAtualizacao;

    int itensTotais;

    int itensRealizados;
}
