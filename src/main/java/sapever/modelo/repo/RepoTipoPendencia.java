package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sapever.modelo.Etapa;
import sapever.modelo.TipoPendencia;

import java.util.List;

public interface RepoTipoPendencia extends JpaRepository<TipoPendencia, Integer> {
}
