package racingcar.domain;

public class Car {

    private final String name;
    private Integer distance = 0;

    private Car(String name) {
        validateName(name);
        this.name = name;
    }

    public static Car create(String name) {
        return new Car(name);
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

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
