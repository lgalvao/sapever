package sapever.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sape_etapa")
public class Etapa {
    @Id
    private int id;

    String descricao;

    @ManyToMany(mappedBy = "etapas")
    List<TipoPendencia> tiposPendencias;
}
