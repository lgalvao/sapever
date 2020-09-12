package sapever.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sape_zona")
public class Zona {
    @Id
    int numero;
}
