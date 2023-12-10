package lotto.domain;

import lotto.domain.dto.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        // given
        Lotto playerLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber playerBonusNumber = LottoNumber.create(7);

        Lotto winningLotto1 = Lotto.create(List.of(5, 6, 7, 8, 9, 10)); // 3개 일치
        Lotto winningLotto2 = Lotto.create(List.of(4, 5, 6, 7, 8, 9)); // 4개 일치
        Lottos winningLottos = Lottos.create(List.of(winningLotto1, winningLotto2));

        lottoService = LottoService.create(winningLottos, playerLotto, playerBonusNumber);
    }

    @Test
    @DisplayName("주어진 로또 번호에 따른 당첨 결과를 반환한다.")
    void generateWinningResult() {
        // when
        Map<Prize, Integer> winningResult = lottoService.generateWinningResult().getWinningResult();
        System.out.println(winningResult.get(Prize.NONE));

        // then
        Assertions.assertThat(winningResult.containsKey(Prize.THREE_NUMBER_MATCH)).isEqualTo(true);
        Assertions.assertThat(winningResult.containsKey(Prize.FOUR_NUMBER_MATCH)).isEqualTo(true);
        Assertions.assertThat(winningResult.get(Prize.THREE_NUMBER_MATCH)).isEqualTo(1);
        Assertions.assertThat(winningResult.get(Prize.FOUR_NUMBER_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 당첨 결과에 따른 총 수익률을 반환한다.")
    void calculateProfitRate() {
        // given
        Integer purchaseAmount = 2000;
        double expectedProfitRate = ((double)(50000 + 5000) / 2000) * 100;

        // when
        WinningResult winningResult = lottoService.generateWinningResult();
        double profitRate = lottoService.calculateProfitRate(winningResult, purchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}