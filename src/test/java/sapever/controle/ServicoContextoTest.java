package sapever.controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sapever.modelo.Etapa;
import sapever.modelo.repo.Repo;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoVerificacoesEtapa;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicoContextoTest {
    @Autowired
    ServicoVerificacao servicoVerificacao;

    @Autowired
    RepoEtapa repoEtapa;

    @MockBean
    Repo repo;

    @BeforeEach
    void inicializar(){
    }

    @Test
    void verificaoBasicaDeveRodarSemErros() {
        Etapa etapaGm = repoEtapa.findById("1").orElseThrow();
        Etapa etapaPrep = repoEtapa.findById("2").orElseThrow();
        Mockito.when(repo.etapasAtivas()).thenReturn(List.of(etapaGm, etapaPrep));

        servicoVerificacao.verificar(etapaGm);
        servicoVerificacao.verificar(etapaPrep);
    }
}