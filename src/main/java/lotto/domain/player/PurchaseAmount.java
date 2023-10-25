package lotto.domain.player;

public class PurchaseAmount {

    private int purchaseAmount;

    public void validateEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("구입 금액은 비어있지 않아야 합니다.");
        }
    }
}
