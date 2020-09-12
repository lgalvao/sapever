package sapever.util;

import lombok.RequiredArgsConstructor;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import sapever.config.Configuracao;
import sapever.verificadores.Verificador;
import sapever.modelo.Etapa;
import sapever.modelo.TipoPendencia;
import sapever.modelo.Zona;
import sapever.modelo.repo.RepoEtapa;
import sapever.modelo.repo.RepoTipoPendencia;
import sapever.modelo.repo.RepoZona;
import sapever.verificadores.ConfigPendencia;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerificadorUtil {
    final Reflections reflections;

    final RepoTipoPendencia repoTipoPendencia;
    final RepoEtapa repoEtapa;
    final RepoZona repoZona;

    final Configuracao configuracao;

    public Set<Class<?>> obterClassesVerificadores() {
        return reflections.getTypesAnnotatedWith(ConfigPendencia.class);
    }

    public int obterCodPendencia(Class<?> classe) {
        return classe.getAnnotation(ConfigPendencia.class).codigo();
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
            if (classe.getAnnotation(ConfigPendencia.class).codigo() == tipoPendencia.getCodigo())
                return obterObjetoVerificador(classe);
        }
        throw new SapeException("Deveria ter encontrado o verificador");
    }

    public List<Etapa> etapasAtivas() {
        return configuracao.getEtapasAtivas().stream()
                .map(cdEtapa -> repoEtapa.findById(cdEtapa).orElseThrow())
                .collect(Collectors.toList());
    }

    public List<Zona> zonasTurnoAtual() {
        return zonasTurno(configuracao.getTurno());
    }

    private List<Zona> zonasTurno(int turno) {
        return repoZona.findAll();
    }

}
