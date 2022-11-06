package KP2;

public class ValidationUtils {
    public static void Validation(String object) {
        if (object == null || object.isBlank()) {
            throw new IllegalArgumentException("Некорректный ввод");
        }
    }
}
