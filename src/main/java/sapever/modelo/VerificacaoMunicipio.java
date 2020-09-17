package sapever.modelo;

import lombok.Data;
import sapever.modelo.enums.SituacaoRelatorios;
import sapever.modelo.enums.SituacaoVerificacao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SAPE_VERIFICACAO_MUNICIPIO", schema = "ADMSUPRE2TESTE")
@Data
public class VerificacaoMunicipio {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "SIT_VERIFICACAO")
    @Enumerated(EnumType.STRING)
    SituacaoVerificacao situacaoVerificacao;

    @Column(name = "SIT_RELATORIOS")
    @Enumerated(EnumType.STRING)
    SituacaoRelatorios situacaoRelatorios;

    @Column(name = "DET_RELATORIOS")
    String detalhamentoRelatorios;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_MUNICIPIO", referencedColumnName = "COD_OBJETO")
    Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ANDAMENTO", referencedColumnName = "COD_OBJETO")
    Andamento andamento;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_VERIFICACAO_ETAPA", referencedColumnName = "COD_OBJETO")
    VerificacaoEtapa verificacaoEtapa;

    @Column(name = "DAT_ULT_ATUALIZACAO")
    LocalDateTime dataHoraUltAtualizacao;

    int itensTotais;

    int itensRealizados;
}
