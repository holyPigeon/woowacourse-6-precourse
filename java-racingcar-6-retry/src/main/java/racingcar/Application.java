package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        OutputView outputView = OutputView.create();
        RacingController racingController = RacingController.create(inputView, outputView);

        racingController.run();
    }
}
