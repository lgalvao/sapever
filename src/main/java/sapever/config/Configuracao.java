package sapever.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "aplicacao")
@PropertySource("classpath:application.yml")
@Component
@Data
public class Configuracao {
    int pleito;
    int eleicao;
    int processo;
    int turno;
    List<Integer> etapasAtivas;

    /**
     * Unifica a criação do RestTemplate, para facilitar testes de integração
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}