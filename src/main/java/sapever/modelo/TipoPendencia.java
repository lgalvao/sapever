package sapever.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "sape_pendencia")
public class TipoPendencia {
    @Id
    Integer id;

    String descricao;

    @ManyToMany
    List<Etapa> etapas;
}