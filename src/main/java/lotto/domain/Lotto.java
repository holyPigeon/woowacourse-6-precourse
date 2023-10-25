package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        validate(numberList);
        this.numberList = numberList;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
