package lotto.domain.player;

import static java.lang.Character.*;
import static java.lang.Integer.*;

public class BonusNumber {
    private int bonusNumber;

    public void validate(String bonusNumber) {
        validateEmpty(bonusNumber);
        validateLength(bonusNumber);
        validateDigit(bonusNumber);
        validateRange(bonusNumber);
    }

    public void validateEmpty(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("보너스 숫자는 비어있지 않아야 합니다.");
        }
    }

    public void validateLength(String bonusNumber) {
        if (bonusNumber.length() < 3) {
            throw new IllegalArgumentException("보너스 숫자는 1자리, 또는 2자리이어야 합니다.");
        }
    }

    public void validateDigit(String bonusNumber) {
        if (!isDigit(parseInt(bonusNumber))) {
            throw new IllegalArgumentException("보너스 숫자는 정수이어야 합니다.");
        }
    }

    public void validateRange(String bonusNumber) {
        if (parseInt(bonusNumber) < 1 || parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("보너스 숫자는 1~45의 숫자이어야 합니다.");
        }
    }
}
