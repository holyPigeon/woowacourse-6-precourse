package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    @DisplayName("주어진 strike과 ball 개수에 따른 힌트 메시지를 반환한다.")
    public void getHintMessageTest() {
        // when
        Hint hint1 = Hint.create(1, 2);
        Hint hint2 = Hint.create(0, 2);
        Hint hint3 = Hint.create(3, 0);
        Hint hint4 = Hint.create(0, 0);

        // then
        Assertions.assertThat(hint1.getHintMessage()).isEqualTo("2볼 1스트라이크");
        Assertions.assertThat(hint2.getHintMessage()).isEqualTo("2볼 ");
        Assertions.assertThat(hint3.getHintMessage()).isEqualTo("3스트라이크");
        Assertions.assertThat(hint4.getHintMessage()).isEqualTo("낫싱");
    }
}