package sapever.controle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoEtapa extends JpaRepository<Etapa, Integer> {
    List<Etapa> findAlllByAtivaIsTrue();
}
