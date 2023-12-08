package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateIsValidLength(numbers);
    }

    private void validateIsValidLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void validateIsEachNumberValid(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < 1 || number > 6)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 1~45 범위에 속하지 않습니다.");
        }
    }
}
