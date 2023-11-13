package christmas.validator;

import static java.lang.Integer.parseInt;

public class InputValidator {

    private InputValidator() {

    }

    public static void validateEstimatedVisitingDateInput(String input) {
        validateIsBlank(input);
        validateIsDigit(input);
    }

    private static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수이어야 합니다.");
        }
    }

    private static boolean isDigit(String input) {
        try {
            parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
