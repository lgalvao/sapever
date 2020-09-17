package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sapever.modelo.Pleito;

import java.util.Optional;

public interface RepoPleito extends JpaRepository<Pleito, String> {
    Optional<Pleito> findAllByAtualIsTrue();
}

