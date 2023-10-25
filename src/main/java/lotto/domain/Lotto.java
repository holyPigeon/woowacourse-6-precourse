package lotto.domain;

import java.util.Arrays;
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

    public void validateLength(List<Integer> numberList) {
        if (numberList.size() != 6) {
            throw new IllegalArgumentException("당첨 번호의 숫자는 6개이어야 합니다.");
        }
    }

    public void validateDigit(List<Integer> numberList) {
        if (numberList.stream()
                .anyMatch(n -> !Character.isDigit(n))) {
            throw new IllegalArgumentException("당첨 번호의 숫자는 모두 정수이어야 합니다.");
        }
    }

    public List<Integer> convertLottoStringToList(String lottoString) {
        String[] splitResult = lottoString.split(", ");
        validateSplit(lottoString, splitResult);
        return Arrays.stream(splitResult)
                .map(Integer::parseInt)
                .toList();
    }

    public void validateSplit(String originalString, String[] splitResult) {
        if (originalString.equals(splitResult[0])) {
            throw new IllegalArgumentException("당첨 번호는 \", \"를 기준으로 구분되어야 합니다.");
        }
    }
}
