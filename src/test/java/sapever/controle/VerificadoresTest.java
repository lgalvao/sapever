package sapever.controle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sapever.modelo.RepoTipoPendencia;

@SpringBootTest
@Slf4j
class VerificadoresTest {
    @Autowired
    RepoTipoPendencia repoTipoPendencia;

    @Autowired
    Verificadores verificadores;

    @Test
    void obterVerificadores() {
        log.info("Tipos de pendências: {}", repoTipoPendencia.findAll());

        repoTipoPendencia.findAll().forEach(
                tipoPendencia -> verificadores.obterVerificador(tipoPendencia)
        );
    }

    @Test
    void executarVerificadores() {
        repoTipoPendencia.findAll().forEach(
                tipoPendencia -> verificadores.obterVerificador(tipoPendencia).verificar()
        );
    }

}