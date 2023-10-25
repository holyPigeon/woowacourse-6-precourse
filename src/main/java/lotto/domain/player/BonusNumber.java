package lotto.domain.player;

public class BonusNumber {
    private int bonusNumber;

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
}
