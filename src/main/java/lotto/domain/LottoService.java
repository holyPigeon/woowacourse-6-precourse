package lotto.domain;

import lotto.domain.dto.WinningResult;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private Lottos winningLottos;
    private Lotto playerLotto;
    private LottoNumber playerBonusNumber;

    private LottoService(Lottos winningLottos, Lotto playerLotto, LottoNumber playerBonusNumber) {
        this.winningLottos = winningLottos;
        this.playerLotto = playerLotto;
        this.playerBonusNumber = playerBonusNumber;
    }

    public static LottoService create(Lottos winningLottos, Lotto playerLotto, LottoNumber playerBonusNumber) {
        return new LottoService(winningLottos, playerLotto, playerBonusNumber);
    }

    public WinningResult generateWinningResult() {
        List<Lotto> winningLottos = this.winningLottos.getLottos();
        Map<Prize, Integer> winningResult = new EnumMap<>(Prize.class);

        for (Lotto winningLotto : winningLottos) {
            List<LottoNumber> winningLottoNumbers = winningLotto.getNumbers();

            // 일반 숫자 포함 여부 확인
            int matchCount = (int) playerLotto.getNumbers().stream()
                    .filter(winningLottoNumbers::contains)
                    .count();

            // 보너스 숫자 포함 여부 확인
            boolean hasBonusNumber= winningLottoNumbers.contains(playerBonusNumber);

            // 사용자 로또와 각각의 당첨 로또를 비교하여 해당하는 당첨 결과를 맵에 담는다.
            Prize findPrize = Prize.findPrizeByMatchCountAndBonusNumber(matchCount, hasBonusNumber);
            winningResult.put(findPrize, winningResult.getOrDefault(findPrize, 0) + 1);
        }

        return WinningResult.create(winningResult);
    }
}
