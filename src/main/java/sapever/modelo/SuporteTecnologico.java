package sapever.modelo;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "VW_SAPE_ST", schema = "ADMSUPRE2TESTE")
@Data
@Immutable
public class SuporteTecnologico {
    @Id
    @Column(name = "COD_OBJETO")
    String id;

    @ManyToOne
    @JoinColumn(name = "COD_OBJETO_POLO", referencedColumnName = "COD_OBJETO")
    Polo polo;

    @Column(name = "NOM_TECNICO")
    String nome;

    String telefones;
}