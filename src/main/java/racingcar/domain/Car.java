package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private Integer distance;

    private Car(String name, Integer distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    public static Car create(String name, Integer distance) {
        return new Car(name, distance);
    }

    private void validateName(String name) {
        validateHasValidLength(name);
    }

    private void validateHasValidLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 입력값의 길이가 유효하지 않습니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }

    public String getMovementResult() {
        return "-".repeat(distance);
    }
}
