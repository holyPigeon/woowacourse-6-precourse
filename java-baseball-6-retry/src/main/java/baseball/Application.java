package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        OutputView outputView = OutputView.create();
        BaseballController baseballController = BaseballController.create(inputView, outputView);

        baseballController.run();
    }
}
