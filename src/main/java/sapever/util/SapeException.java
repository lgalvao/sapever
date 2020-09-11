package sapever.util;

public class SapeException extends RuntimeException {
    public SapeException(Exception e) {
        super(e);
    }

    public SapeException(String mensagem) {
        super(mensagem);
    }
}
