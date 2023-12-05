package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Numbers create(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public void validateNumbers(List<Integer> numbers) {
        validateIsEachNumberNotZero(numbers);
        validateIsEachNumberUnique(numbers);
    }

    private void validateIsEachNumberNotZero(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number == 0)) {
            throw new IllegalArgumentException("[ERROR] 각 자리수는 0일 수 없습니다.");
        }
    }

    private void validateIsEachNumberUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 각 자리수는 중복될 수 없습니다.");
        }
    }
}
