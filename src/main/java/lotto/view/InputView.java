package lotto.view;

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
    로또 구입금액 입력
     */
    public Integer readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePurchaseAmountInput(input);

        return Integer.parseInt(input);
    }

    private void validatePurchaseAmountInput(String input) {
        validateIsBlank(input);
        validateIsDigit(input);
        validateIsPurchaseAmountUnitValid(input);
    }

    private void validateIsPurchaseAmountUnitValid(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 구입금액 단위가 아닙니다.");
        }
    }

    /*
    로또 당첨번호 입력
     */
    public List<Integer> readPlayerLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validatePlayerLottoInput(input);

        return parsePlayerLottoInput(input);
    }

    private void validatePlayerLottoInput(String input) {
        validateIsBlank(input);
        validateIsValidFormat(input);
    }

    private void validateIsValidFormat(String input) {
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 유효한 입력 형식이 아닙니다.");
        }
    }

    private boolean isValidFormat(String input) {
        String regex = "\\d+(,\\d+)*";

        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    private List<Integer> parsePlayerLottoInput(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    /*
    보너스 번호 입력
     */
    public Integer readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateBonusNumberInput(input);

        return Integer.parseInt(input);
    }

    private void validateBonusNumberInput(String input) {
        validateIsBlank(input);
        validateIsDigit(input);
    }

    /*
     공통 검증
      */
    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있습니다.");
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

    public void closeRead() {
        Console.close();
    }
}