package lotto.domain.player;

public class PurchaseAmount {

    private int purchaseAmount;

    public void validateEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("구입 금액은 비어있지 않아야 합니다.");
        }
    }

    public void validateDigit(String string) {
        if (string.chars()
                .anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("구입 금액은 정수이어야 합니다.");
        }
    }
}
