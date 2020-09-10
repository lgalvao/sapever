package sapever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SapeverApplication {
    public static void main(String[] args) {
        SpringApplication.run(SapeverApplication.class, args);
    }
}
