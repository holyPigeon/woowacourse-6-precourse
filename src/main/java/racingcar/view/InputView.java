package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private InputView() {

    }

    public static InputView create() {
        return new InputView();
    }

    /*
    자동차 이름 목록 입력
     */
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNamesInput(input);

        return parseCarNamesInput(input);
    }

    private void validateCarNamesInput(String input) {
        validateHasValidFormat(input);
    }

    private void validateHasValidFormat(String input) {
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 유효한 포맷이 아닙니다.");
        }
    }

    private boolean isRightFormat(String input) {
        String regex = "^[a-z]+(?:,[a-z]+)+$";

        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    private List<String> parseCarNamesInput(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    /*
    경주 시도 횟수 입력
     */
    public Integer readTryCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateTryCount(input);

        return Integer.parseInt(input);
    }

    private void validateTryCount(String input) {
        validateIsBlank(input);
        validateIsDigit(input);
    }

    private void validateIsBlank(String input) {
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
}
