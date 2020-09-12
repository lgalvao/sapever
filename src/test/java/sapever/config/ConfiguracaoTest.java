package sapever.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sapever.verificadores.Verificador;
import sapever.verificadores.ConfigPendencia;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ConfiguracaoTest {
    @Autowired
    Configuracao configuracao;

    Reflections reflections;

    @BeforeEach
    void inicializar() {
        reflections = new Reflections("sapever.modelo.verificadores");
    }

    @Test
    void testarConfiguracao() {
        assertThat(configuracao).hasNoNullFieldsOrProperties();
    }

    @Test
    void todasClassesVerificacaoDevemEstarAnotadas() {
        var verificadores = reflections.getSubTypesOf(Verificador.class);
        verificadores.forEach(classe -> {
            var anotacao = classe.getAnnotation(ConfigPendencia.class);
            assertThat(anotacao).isNotNull();
        });
    }
}