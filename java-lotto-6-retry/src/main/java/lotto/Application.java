package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        OutputView outputView = OutputView.create();
        LottoController lottoController = LottoController.create(inputView, outputView);

        lottoController.run();
    }
}
