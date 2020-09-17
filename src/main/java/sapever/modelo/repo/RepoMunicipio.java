package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sapever.modelo.Municipio;

import java.util.List;

@Repository
public interface RepoMunicipio extends JpaRepository<Municipio, String> {
    @Query("select secao.numero from Secao secao where secao.municipio = :municipio")
    List<Integer> numerosSecoes(@Param("municipio") Municipio municipio);
}
