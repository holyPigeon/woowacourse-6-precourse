package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto create(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateIsValidLength(numbers);
    }

    private void validateIsValidLength(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 6개가 아닙니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
