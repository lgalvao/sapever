package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sapever.modelo.Etapa;
import sapever.modelo.Zona;

import java.util.List;

@Repository
public interface RepoZona extends JpaRepository<Zona, String> {
    @Query("select z from Zona z where z.pleito.atual = true")
    List<Zona> todasPleitoAtual();
}
