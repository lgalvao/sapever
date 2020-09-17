package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VW_SAPE_ZONA", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class Zona {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NUM_ZONA")
    int numero;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_PLEITO", referencedColumnName = "COD_OBJETO")
    Pleito pleito;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_MUNICIPIO_SEDE", referencedColumnName = "COD_OBJETO")
    Municipio municipioSede;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VW_SAPE_MUNICIPIO_ZONA",
            joinColumns = {@JoinColumn(name = "COD_OBJETO_ZONA")},
            inverseJoinColumns = {@JoinColumn(name = "COD_OBJETO_MUNICIPIO")})
    List<Municipio> municipios;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_POLO", referencedColumnName = "COD_OBJETO")
    Polo polo;

    boolean sedePolo;
}
