package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4 이상의 값이라면 자동차가 1만큼 이동한다.")
    void move1() {
        // given
        Car car = Car.create("pobi");

        // when
        car.move(5);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만의 값이라면 자동차가 이동하지 않는다.")
    void move2() {
        // given
        Car car = Car.create("pobi");

        // when
        car.move(3);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }
}