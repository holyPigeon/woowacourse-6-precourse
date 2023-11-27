package lotto.domain.player;

import java.util.List;

public class Player {
    private List<Integer> lottoList;

    private PurchaseAmount purchaseAmount;

    private BonusNumber bonusNumber;

    public Player(List<Integer> lottoList, String purchaseAmount, String bonusNumber) {
        this.lottoList = lottoList;
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }
}
