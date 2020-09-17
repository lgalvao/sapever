package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "SAPE_TIPO_PENDENCIA_ETAPA", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class TipoPendenciaEtapa {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ETAPA", referencedColumnName = "COD_OBJETO")
    Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_TIPO_PENDENCIA", referencedColumnName = "COD_OBJETO")
    TipoPendencia tipoPendencia;
}

