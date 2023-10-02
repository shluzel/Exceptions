package HW03;

import java.io.IOException;

public class LocalException extends RuntimeException {
    public LocalException(String message) {
        super("Ошибка во введенных данных: " + message);
    }
}
