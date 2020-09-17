package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CRONOGRAMA_ETAPA", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class Cronograma {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ETAPA", referencedColumnName = "COD_OBJETO")
    Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ZONA", referencedColumnName = "COD_OBJETO")
    Zona zona;

    @Column(name = "DAT_INICIO")
    LocalDateTime dataHoraInicio;

    @Column(name = "DAT_FIM")
    LocalDateTime dataHoraFim;
}
