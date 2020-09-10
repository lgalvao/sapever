package sapever.controle;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import sapever.modelo.TipoPendencia;
import sapever.util.SapeException;
import sapever.verificadores.ConfigPendencia;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class Verificadores {
    private Map<Integer, String> mapaVerificadores;
    private Reflections reflections;

    @PostConstruct
    void inicializar() {
    }

    Verificador obterVerificador(TipoPendencia tipoPendencia) {
        mapaVerificadores = mapearVerificadores();
        reflections = new Reflections("sapever");

        int codigoPendencia = tipoPendencia.getId();
        String nomeVerificador = mapaVerificadores.get(codigoPendencia);
        try {
            return (Verificador) Class.forName(nomeVerificador).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Erro ao instanciar verificador para pendência {}", codigoPendencia);
            throw new SapeException(e);
        }
    }

    List<Integer> obterTodosCodigosVerificadores() {
        var verificadores = reflections.getSubTypesOf(Verificador.class);
        return verificadores.stream()
                .map(classe -> classe.getAnnotation(ConfigPendencia.class).codigo())
                .collect(Collectors.toList());
    }

    Map<Integer, String> mapearVerificadores() {
        var verificadores = reflections.getSubTypesOf(Verificador.class);

        Map<Integer, String> mapa = new HashMap<>();
        verificadores.forEach(verificador -> mapa.put(codigoVerificador(verificador), verificador.getCanonicalName()));

        return mapa;
    }

    private int codigoVerificador(Class<? extends Verificador> classe) {
        return classe.getAnnotation(ConfigPendencia.class).codigo();
    }

}
