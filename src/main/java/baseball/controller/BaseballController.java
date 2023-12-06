package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.Numbers;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    private BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static BaseballController create(InputView inputView, OutputView outputView) {
        return new BaseballController(inputView, outputView);
    }

    public void run() {
        outputView.gameStartMessage();
        boolean gameRetry = false;

        do {
            Numbers computerNumbers = Numbers.create(RandomNumberGenerator.generateRandomNumbers());
            matchNumbers(computerNumbers);
            gameRetry = readRetryCommand(gameRetry);
        } while (gameRetry);
    }

    private void matchNumbers(Numbers computerNumbers) {
        while (true) {
            Numbers playerNumbers = Numbers.create(inputView.readPlayerNumber());

            Hint hint = playerNumbers.generateHint(computerNumbers);
            if (hint.isThreeStrike()) {
                outputView.gameEndMessage();
                break;
            }
            outputView.printHintMessage(hint.getHintMessage());
        }
    }

    private boolean readRetryCommand(boolean gameRetry) {

        return inputView.readGameRetryCommand() == 1;
    }
}
