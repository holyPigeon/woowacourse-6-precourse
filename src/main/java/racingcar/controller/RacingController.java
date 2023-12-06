package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;

    private RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static RacingController create(InputView inputView, OutputView outputView) {
        return new RacingController(inputView, outputView);
    }

    public void run() {
        Cars cars = readCars();
        Integer tryCount = readTryCount();

        outputView.printRaceResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveEachCars();
            outputView.printMovementResult(cars.getMovementResult());
        }
    }

    private Integer readTryCount() {
        return inputView.readTryCount();
    }

    private Cars readCars() {
        List<Car> cars = inputView.readCarNames().stream()
                .map(Car::create)
                .toList();

        return Cars.create(cars);
    }
}
