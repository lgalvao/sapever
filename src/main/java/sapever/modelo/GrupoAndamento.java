package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import sapever.modelo.enums.TipoVisao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SAPE_GRUPO_ANDAMENTO", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class GrupoAndamento {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @OneToMany(mappedBy = "grupoAndamento")
    List<Andamento> andamentos;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ETAPA", referencedColumnName = "COD_OBJETO")
    Etapa etapa;

    // TODO avaliar se precisamos mesmo ter essa referência explícita a detalhes da interface com o usuário
    @Enumerated(EnumType.STRING)
    @Column(name = "TIP_VISAO")
    TipoVisao tipoVisao;
}
