package christmas.validator;

public class InputValidator {

    private InputValidator() {

    }

    public static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있지 않아야 합니다.");
        }
    }
}
