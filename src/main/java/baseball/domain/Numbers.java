package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Numbers {

    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers create(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    /*
    검증 로직
     */
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

    /*
    비즈니스 로직
     */
    public Hint generateHint(Numbers computerNumbers) {
        return Hint.create(getStrikeCount(computerNumbers.numbers), getBallCount(computerNumbers.numbers));
    }

    private int getStrikeCount(List<Integer> computerNumbers) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }

    private int getBallCount(List<Integer> computerNumbers) {
        return (int) IntStream.range(0, computerNumbers.size())
                .filter(i -> !numbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }
}
