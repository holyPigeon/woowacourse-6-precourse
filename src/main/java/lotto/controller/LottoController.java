package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public String readPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        return inputView.read();
    }

    public int getLottoCount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }
}