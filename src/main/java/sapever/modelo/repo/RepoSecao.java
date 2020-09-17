package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sapever.modelo.Secao;

@Repository
public interface RepoSecao extends JpaRepository<Secao, String> {
}
