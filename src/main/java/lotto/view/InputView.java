package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static InputView create() {
        return new InputView();
    }

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