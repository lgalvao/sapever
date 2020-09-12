package sapever.util;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class Gerador {
    public final static Faker faker = new Faker(Locale.forLanguageTag("pt_BR"));

    public static Faker faker() {
        return faker;
    }

    public static String gerarNome() {
        return faker.name().fullName();
    }

    public static String gerarNomeSocial() {
        return faker.gameOfThrones().character();
    }

    public static boolean gerarBooleano() {
        return faker().bool().bool();
    }

    public static LocalDate gerarDataAntesDe(@NonNull LocalDate d, int diasMax) {
        Date dataMaxima = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataRetorno = faker.date().past(diasMax, TimeUnit.DAYS, dataMaxima);
        return dataParaLocalDate(dataRetorno);
    }

    public static LocalDate gerarDataDepoisDe(@NonNull LocalDate d, int diasMax) {
        Date dataMinima = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataRetorno = faker.date().future(diasMax, TimeUnit.DAYS, dataMinima);
        return dataParaLocalDate(dataRetorno);
    }

    public static LocalDate gerarDataIntervalo(@NonNull LocalDate min, LocalDate max) {
        Date dataMinima = Date.from(min.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dataMaxima = Date.from(max.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date dataRetorno = faker.date().between(dataMinima, dataMaxima);
        return dataParaLocalDate(dataRetorno);
    }

    public static LocalDate gerarDataNascimento() {
        // Data nos últimos ~99 anos
        Date dataTemp = faker.date().past(99 * 365, TimeUnit.DAYS);
        return dataParaLocalDate(dataTemp);
    }

    public static int gerarInteiro(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static String gerarEmail() {
        return StringUtils.stripAccents(faker.internet().emailAddress());
    }

    public static String gerarTelefone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String gerarCep() {
        return faker.address().zipCode();
    }

    public static String gerarDescLogradouro() {
        return faker.address().streetAddress();
    }

    public static String gerarMatricula() {
        return faker.numerify("JE#######");
    }

    public static String gerarTituloEleitor() {
        return faker.numerify("############");
    }

    public static String gerarNis() {
        return faker.numerify("###.#####.##-#");
    }

    public static String gerarCpf() {
        int digito1;
        int digito2;
        int resto;

        String nDigResult;
        String concatenados;
        String numeroGerado;
        Random numeroAleatorio = new Random();

        int n1 = numeroAleatorio.nextInt(10);
        int n2 = numeroAleatorio.nextInt(10);
        int n3 = numeroAleatorio.nextInt(10);
        int n4 = numeroAleatorio.nextInt(10);
        int n5 = numeroAleatorio.nextInt(10);
        int n6 = numeroAleatorio.nextInt(10);
        int n7 = numeroAleatorio.nextInt(10);
        int n8 = numeroAleatorio.nextInt(10);
        int n9 = numeroAleatorio.nextInt(10);
        int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;
        int valor = (soma / 11) * 11;
        digito1 = soma - valor;

        resto = (digito1 % 11);
        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;
        int valor2 = (soma2 / 11) * 11;
        digito2 = soma2 - valor2;

        resto = (digito2 % 11);
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        concatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4)
                + String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)
                + String.valueOf(n9);

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        numeroGerado = concatenados + nDigResult;

        return numeroGerado;
    }

    private static LocalDate dataParaLocalDate(Date data) {
        return Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
