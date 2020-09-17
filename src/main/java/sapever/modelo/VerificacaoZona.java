package sapever.modelo;

import lombok.Data;
import sapever.modelo.enums.SituacaoRelatorios;
import sapever.modelo.enums.SituacaoVerificacao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SAPE_VERIFICACAO_ZONA", schema = "ADMSUPRE2TESTE")
@Data
public class VerificacaoZona {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "SIT_VERIFICACAO")
    SituacaoVerificacao situacaoVerificacao;

    @Column(name = "DAT_ULT_ATUALIZACAO")
    LocalDateTime dataHoraUltAtualizacao;

    @Column(name = "SIT_RELATORIOS")
    @Enumerated(EnumType.STRING)
    SituacaoRelatorios situacaoRelatorios;

    @Column(name = "DET_RELATORIOS")
    String detRelatorios;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ZONA", referencedColumnName = "COD_OBJETO")
    Zona zona;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ANDAMENTO", referencedColumnName = "COD_OBJETO")
    Andamento andamento;

    @OneToMany
    @JoinColumn(name = "COD_OBJETO_VERIFICACAO_ZONA", referencedColumnName = "COD_OBJETO")
    List<Pendencia> pendencia;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_VERIFICACAO_ETAPA", referencedColumnName = "COD_OBJETO")
    VerificacaoEtapa verificacaoEtapa;

    int itensTotais;

    int itensRealizados;
}
