package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(
                numbers.stream()
                        .map(LottoNumber::create)
                        .toList()
        );
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateIsValidLength(numbers);
        validateHasDuplicatedNumber(numbers);
    }

    private void validateIsValidLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void validateHasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
