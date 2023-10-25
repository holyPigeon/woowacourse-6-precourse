package lotto.domain.player;

public class BonusNumber {
    private int bonusNumber;

    public void validateEmpty(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("보너스 숫자는 비어있지 않아야 합니다.");
        }
    }
}
