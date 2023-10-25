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

    public void validateSplit(String originalString, String[] splitResult) {
        if (originalString.equals(splitResult[0])) {
            throw new IllegalArgumentException("당첨 번호는 \", \"를 기준으로 구분되어야 합니다.");
        }
    }
}
