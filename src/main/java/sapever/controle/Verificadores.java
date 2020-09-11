package sapever.controle;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.springframework.stereotype.Service;
import sapever.modelo.TipoPendencia;
import sapever.util.SapeException;
import sapever.verificadores.ConfigPendencia;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class Verificadores {
    private final Map<Integer, String> mapaVerificadores = mapearVerificadores();

    public Verificador obterVerificador(TipoPendencia tipoPendencia) {
        int codigoPendencia = tipoPendencia.getId();
        String nomeVerificador = mapaVerificadores.get(codigoPendencia);
        try {
            log.info("Tentando instancicar classe {}", nomeVerificador);
            return (Verificador) Class.forName(nomeVerificador).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Erro ao instanciar verificador para pendência {}", codigoPendencia);
            throw new SapeException(e);
        }
    }

    private Map<Integer, String> mapearVerificadores() {
        final Map<Integer, String> retorno = new HashMap<>();
        Reflections reflections = new Reflections("sapever.verificadores",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
        var verificadores = reflections.getTypesAnnotatedWith(ConfigPendencia.class);
        verificadores.forEach(v -> System.out.println(v.getName()));


        return retorno;
    }

    private int obterCodigoVerificador(Class<? extends Verificador> classe) {
        return classe.getAnnotation(ConfigPendencia.class).codigo();
    }
}
