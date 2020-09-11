package sapever.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Zona {
    @Id
    int numero;
}
