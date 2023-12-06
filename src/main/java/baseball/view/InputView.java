package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {

    }

    private static InputView create() {
        return new InputView();
    }

    public List<Integer> readPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validatePlayerNumberInput(input);

        return parsePlayerNumberInput(input);
    }

    private void validatePlayerNumberInput(String input) {
        validateIsNotBlank(input);
        validateIsDigit(input);
        validateIsValidLength(input);
    }

    private void validateIsNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 정수가 아닙니다.");
        }
    }

    private boolean isDigit(String input) {
        try {
            Integer.parseInt(input);

            return true;
        } catch (NumberFormatException e) {

            return false;
        }
    }

    private void validateIsValidLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 입력값의 길이가 유효하지 않습니다.");
        }
    }

    private List<Integer> parsePlayerNumberInput(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

}
