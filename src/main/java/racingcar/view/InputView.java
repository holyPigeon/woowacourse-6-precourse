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
}
