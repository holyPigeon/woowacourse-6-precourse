package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveEachCars() {
        cars.forEach(car -> car.move(RandomNumberGenerator.pickRandomNumber()));
    }

    private List<Car> getMostMovedCars() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public String getMovementResult() {
        return cars.stream()
                .map(car -> String.format("%s : %s", car.getName(), car.getMovementResult()))
                .reduce((result, carString) -> String.join("\n", result, carString))
                .orElse("");
    }

    public String getWinnersResult() {
        return getMostMovedCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
