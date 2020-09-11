package sapever.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class Pendencia {
    @Id
    int id;

    @ManyToOne
    Zona zona;

    @ManyToOne
    Etapa etapa;

    @ManyToOne
    TipoPendencia tipoPendencia;

    LocalDateTime dataHoraRegistro;
}