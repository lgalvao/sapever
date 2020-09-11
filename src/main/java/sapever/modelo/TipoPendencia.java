package sapever.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sape_pendencia")
public class TipoPendencia {
    @Id
    Integer codigo;

    String descricao;

    @ManyToMany
    @JoinTable(name = "sape_pendencia_etapa")
    List<Etapa> etapas;
}