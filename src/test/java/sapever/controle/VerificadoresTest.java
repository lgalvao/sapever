package sapever.controle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sapever.modelo.Etapa;
import sapever.modelo.TipoPendencia;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.verificadores.ConfigPendencia;

import java.util.List;
import java.util.Set;

@SpringBootTest
@Slf4j
class VerificadoresTest {
    @Autowired
    RepoTipoPendencia repoTipoPendencia;

    @Autowired
    RepoEtapa repoEtapa;

    Reflections reflections;

    @BeforeEach
    void inicializar() {
        reflections = new Reflections("sapever.verificadores",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
    }

    @Test
    void chamarTodosVerificadores() throws Exception {
        for (var classe : reflections.getTypesAnnotatedWith(ConfigPendencia.class)) {
            Verificador verificador = (Verificador) classe.getDeclaredConstructor().newInstance();
            verificador.verificar();
        }
    }

    @Test
    void chamarTodosVerificadoresDeUmaEtapa() throws Exception {
        Etapa etapaGeracao = repoEtapa.findById(1).orElseThrow();
        var codigosPendenciasEtapa = repoTipoPendencia.codigosPendenciaEtapa(etapaGeracao);
        for (var classe : reflections.getTypesAnnotatedWith(ConfigPendencia.class)) {
            int codigo = classe.getAnnotation(ConfigPendencia.class).codigo();
            if (codigosPendenciasEtapa.contains(codigo)) {
                Verificador verificador = (Verificador) classe.getDeclaredConstructor().newInstance();
                verificador.verificar();
            }
        }
    }

    @Test
    void verificarTodasEtapas() throws Exception {
        for (Etapa etapa : repoEtapa.findAll()) {
            log.info("=====> Verificando etapa {}", etapa.getDescricao());
            verificarEtapa(etapa);
        }
    }

    @Test
    void verificarTodosTiposPendencias() throws Exception {
        for (TipoPendencia tipoPendencia : repoTipoPendencia.findAll()) {
            verificarTipoPendencia(tipoPendencia);
        }
    }

    private void verificarTipoPendencia(TipoPendencia tipoPendencia) throws Exception {
        for (Class<?> classeVerificador : classesVerificadores()) {
            if (codPendencia(classeVerificador) == tipoPendencia.getCodigo()) {
                objetoVerificador(classeVerificador).verificar();
            }
        }
    }

    private void verificarEtapa(Etapa etapa) throws Exception {
        List<Integer> codigosPendenciasEtapa = repoTipoPendencia.codigosPendenciaEtapa(etapa);

        for (Class<?> classeVerificador : classesVerificadores()) {
            int codigo = codPendencia(classeVerificador);
            if (codigosPendenciasEtapa.contains(codigo)) {
                objetoVerificador(classeVerificador).verificar();
            }
        }
    }

    private Verificador objetoVerificador(Class<?> classe) throws Exception {
        return (Verificador) classe.getDeclaredConstructor().newInstance();
    }

    private Set<Class<?>> classesVerificadores() {
        return reflections.getTypesAnnotatedWith(ConfigPendencia.class);
    }

    private int codPendencia(Class<?> classe) {
        return classe.getAnnotation(ConfigPendencia.class).codigo();
    }

}