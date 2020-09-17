package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Immutable
public class Polo {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @Column(name = "NUM_POLO")
    int numero;

    @OneToMany(mappedBy = "polo")
    List<Zona> zonas;

    @OneToMany(mappedBy = "polo")
    List<SuporteTecnologico> sts;
}
