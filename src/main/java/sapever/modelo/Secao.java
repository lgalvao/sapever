package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Data
@Immutable
public class Secao {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NUM_SECAO")
    int numero;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_ZONA", referencedColumnName = "COD_OBJETO")
    Zona zona;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_MUNICIPIO", referencedColumnName = "COD_OBJETO")
    Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;
}
