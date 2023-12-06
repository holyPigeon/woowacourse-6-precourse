package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("주어진 컴퓨터 숫자와 플레이어 숫자를 비교하여 힌트를 반환한다.")
    void generateHint() {
        // given
        Numbers playerNumbers1 = Numbers.create(List.of(1, 2, 3));
        Numbers computerNumbers1 = Numbers.create(List.of(3, 4, 5));
        Numbers playerNumbers2 = Numbers.create(List.of(1, 2, 3));
        Numbers computerNumbers2 = Numbers.create(List.of(4, 5, 6));

        Hint correctHint1 = Hint.create(0, 1);
        Hint correctHint2 = Hint.create(0, 0);

        // when
        Hint hint1 = playerNumbers1.generateHint(computerNumbers1);
        Hint hint2 = playerNumbers2.generateHint(computerNumbers2);

        // then
        Assertions.assertThat(hint1).isEqualTo(correctHint1);
        Assertions.assertThat(hint2).isEqualTo(correctHint2);
    }
}