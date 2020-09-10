package sapever.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEtapa extends JpaRepository<Etapa, Integer> {
}
