package lotto.domain.player;

import static java.lang.Integer.*;

public class PurchaseAmount {

    private int purchaseAmount;

    public void validate(String purchaseAmount) {
        validateEmpty(purchaseAmount);
        validateDigit(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    public void validateEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("구입 금액은 비어있지 않아야 합니다.");
        }
    }

    public void validateDigit(String purchaseAmount) {
        if (purchaseAmount.chars()
                .anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("구입 금액은 정수이어야 합니다.");
        }
    }

    public void validateUnit(String purchaseAmount) {
        if (parseInt(purchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위이어야 합니다.");
        }
    }
}
