package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import sapever.modelo.enums.TipoPleito;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VW_SAPE_PLEITO", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class Pleito {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "DES_PLEITO")
    String descricao;

    @Column(name = "NUM_TURNO")
    int turno;

    int ano;

    /**
     * Determina se esse é o pleito ativo/atual
     */
    boolean atual;

    Integer codProcessoTot;
    Integer codPleitoTot;
    Integer codEleicaoTot;

    @Enumerated(EnumType.STRING)
    TipoPleito tipo;

    @OneToMany(mappedBy = "pleito")
    List<VerificacaoEtapa> verificacoesEtapa;
}
