package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapever.modelo.Zona;

@Repository
public interface RepoZona extends JpaRepository<Zona, Integer> {
}
