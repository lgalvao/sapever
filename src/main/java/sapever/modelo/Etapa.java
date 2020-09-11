package sapever.modelo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "sape_etapa")
public class Etapa {
    @Id
    private int id;

    String descricao;

    @ToString.Exclude
    @ManyToMany(mappedBy = "etapas")
    List<TipoPendencia> tiposPendencias;
}
