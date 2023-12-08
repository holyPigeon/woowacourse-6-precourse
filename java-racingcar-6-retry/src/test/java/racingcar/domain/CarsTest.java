package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("자동차가 이동했을 때, 해당 이동 거리를 문자열로 반환한다.")
    void getMovementResult() {
        // given
        Car car1 = Car.create("pobi1");
        Car car2 = Car.create("pobi2");
        Car car3 = Car.create("pobi3");

        car1.move(5);
        car2.move(3);
        car3.move(3);

        cars = Cars.create(
                List.of(
                        car1,
                        car2,
                        car3
                )
        );

        // when
        String movementResult = cars.getMovementResult();

        // then
        Assertions.assertThat(movementResult).isEqualTo("pobi1 : -\npobi2 : \npobi3 : ");
    }

    @Test
    @DisplayName("세 자동차의 이동거리가 모두 같을 때, 모두를 우승자로 문자열 반환한다.")
    void getWinnersResult1() {
        // given
        Car car1 = Car.create("pobi1");
        Car car2 = Car.create("pobi2");
        Car car3 = Car.create("pobi3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        cars = Cars.create(
                List.of(
                        car1,
                        car2,
                        car3
                )
        );

        // when
        String winnersResult = cars.getWinnersResult();

        // then
        Assertions.assertThat(winnersResult).isEqualTo("pobi1, pobi2, pobi3");
    }

    @Test
    @DisplayName("첫 번째 자동차의 멀리 이동한 경우, 해당 자동차를 우승자로 문자열 반환한다.")
    void getWinnersResult2() {
        // given
        Car car1 = Car.create("pobi1");
        Car car2 = Car.create("pobi2");
        Car car3 = Car.create("pobi3");

        car1.move(5);
        car2.move(3);
        car3.move(3);

        cars = Cars.create(
                List.of(
                        car1,
                        car2,
                        car3
                )
        );

        // when
        String winnersResult = cars.getWinnersResult();

        // then
        Assertions.assertThat(winnersResult).isEqualTo("pobi1");
    }
}