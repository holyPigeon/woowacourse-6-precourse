package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호가 1~45의 범위가 아닐 때 생성 실패한다.")
    @ValueSource(ints = {-1, 0, 100, 300, -52})
    void create(
            // given
            int lottoNumber
    ) {
        // when, then
        assertThatThrownBy(() -> LottoNumber.create(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 당첨 번호가 1~45 범위에 속하지 않습니다."
                );
    }
}