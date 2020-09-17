package sapever.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import sapever.config.Configuracao;
import sapever.modelo.repo.Repo;
import sapever.verificadores.Verificador;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.modelo.repo.RepoZona;
import sapever.verificadores.ConfigPendencia;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class Contexto {
    final Reflections reflections;

    final RepoTipoPendencia repoTipoPendencia;
    final RepoEtapa repoEtapa;
    final RepoZona repoZona;
    final Repo repo;

    final Configuracao configuracao;

    public Set<Class<?>> obterClassesVerificadores() {
        return reflections.getTypesAnnotatedWith(ConfigPendencia.class);
    }

    public Verificador obterObjetoVerificador(Class<?> classe)  {
        try {
            return (Verificador) classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new SapeException("Deveria ter conseguido instanciar");
        }
    }

    public Verificador obterVerificador(TipoPendencia tipoPendencia) {
        var classesVerificadores = obterClassesVerificadores();
        for (var classe : classesVerificadores) {
            if (classe.getAnnotation(ConfigPendencia.class).numero() == tipoPendencia.getNumero()) {
                Verificador verificador = obterObjetoVerificador(classe);
                log.info("Usando verificador {}", verificador.getClass().getName());
                return verificador;
            }
        }
        throw new SapeException("Deveria ter encontrado o verificador");
    }

    public List<Zona> zonasTurnoAtual() {
        return zonasTurno(configuracao.getTurno());
    }

    private List<Zona> zonasTurno(int turno) {
        return repoZona.findAll();
    }

}
