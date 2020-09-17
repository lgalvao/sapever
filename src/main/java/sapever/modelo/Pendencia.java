package sapever.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "SAPE_VER_ZONA_PENDENCIA", schema = "ADMSUPRE2TESTE")
@Data
@Accessors(chain = true)
public class Pendencia {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Lob
    String detalhamento;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_TIPO_PENDENCIA", referencedColumnName = "COD_OBJETO")
    TipoPendencia tipoPendencia;
}
