package sapever.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sape_tipo_pendencia")
public class TipoPendencia {
    @Id
    Integer codigo;

    String descricao;

    @ManyToMany
    @JoinTable(name = "sape_tipopendencia_etapa")
    List<Etapa> etapas;
}