package sapever.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sapever.modelo.Etapa;
import sapever.modelo.Pleito;
import sapever.modelo.TipoPendencia;
import sapever.modelo.VerificacaoEtapa;
import sapever.modelo.enums.SituacaoVerificacao;

import java.util.List;

@Repository
public interface RepoVerificacoesEtapa extends JpaRepository<VerificacaoEtapa, String> {
    @Query("select tpe.tipoPendencia from TipoPendenciaEtapa tpe where tpe.pleito = :pleito and tpe.etapa=:etapa")
    List<TipoPendencia> tiposPendencia(Pleito pleito, Etapa etapa);

    @Query("select ve from VerificacaoEtapa ve where ve.situacaoVerificacao = sapever.modelo.enums.SituacaoVerificacao.ATIVA")
    List<VerificacaoEtapa> verificacaoEtapasAtivas();

    @Query("select ve.etapa from VerificacaoEtapa ve where ve.situacaoVerificacao = sapever.modelo.enums.SituacaoVerificacao.ATIVA")
    List<Etapa> etapasAtivas();
}
