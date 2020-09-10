package sapever.controle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Etapa {
    @Id
    int id;

    @OneToMany
    List<TipoPendencia> tipoPendencias;

    Boolean ativa;
}
