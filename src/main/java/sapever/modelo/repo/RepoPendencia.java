package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sapever.modelo.Pendencia;

public interface RepoPendencia extends JpaRepository<Pendencia, Integer> {
}
