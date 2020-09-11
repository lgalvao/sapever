package sapever.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoTipoPendencia extends JpaRepository<TipoPendencia, Integer> {
    @Query("select distinct tipoPendencia.id from TipoPendencia tipoPendencia " +
            "where :etapa member of tipoPendencia.etapas")
    List<Integer> codigosPendenciaEtapa(@Param("etapa") Etapa etapa);
}
