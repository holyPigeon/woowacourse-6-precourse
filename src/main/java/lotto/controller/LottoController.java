package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;
import static lotto.domain.Lotto.*;

public class LottoController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public String readPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        return inputView.read();
    }

    private void printGeneratedLottoStatus(String purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(generateWinningNumber()));
            outputView.printGeneratedLottoNumberMessage(lottoList.get(i).toString());
        }
    }

    public int getLottoCount(String purchaseAmount) {
        return parseInt(purchaseAmount) / 1000;
    }

    private List<Integer> readPlayerNumberList() {
        outputView.printLottoNumberMessage();
        return convertLottoStringToList(inputView.read());
    }

    private String readBonusNumber() {
        outputView.printBonusNumberMessage();
        return inputView.read();
    }
}