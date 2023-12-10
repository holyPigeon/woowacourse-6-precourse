package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private Integer number;

    private LottoNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber create(Integer number) {
        return new LottoNumber(number);
    }

    private void validate(Integer number) {
        validateIsNumberInRange(number);
    }

    private void validateIsNumberInRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 1~45 범위에 속하지 않습니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
