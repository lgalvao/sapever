package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Immutable
public class Municipio {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NOM_MUNICIPIO")
    String nome;

    @Column(name = "COD_MUNICIPIO_TSE")
    int codTse;

    @Column(name = "COD_MUNICIPIO_IBGE")
    int codIbge;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VW_SAPE_MUNICIPIO_ZONA",
            joinColumns = {@JoinColumn(name = "COD_OBJETO_MUNICIPIO")},
            inverseJoinColumns = {@JoinColumn(name = "COD_OBJETO_ZONA")})
    List<Zona> zonas;

    @OneToMany(mappedBy = "municipio")
    List<Secao> secoes;
}
