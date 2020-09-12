package sapever.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "sape_pendencia")
public class Pendencia {
    @Id
    int id;

    @ManyToOne
    Zona zona;

    @ManyToOne
    Etapa etapa;

    @ManyToOne
    TipoPendencia tipo;

    String detalhamento;

    LocalDateTime dataHoraRegistro;
}