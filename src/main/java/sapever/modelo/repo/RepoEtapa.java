package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapever.modelo.Etapa;

@Repository
public interface RepoEtapa extends JpaRepository<Etapa, Integer> {
}
