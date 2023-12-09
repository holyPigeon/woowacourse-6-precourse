package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class RandomLottoGenerator {

    private RandomLottoGenerator() {

    }

    public static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return Lotto.create(
                randomNumbers.stream()
                .map(LottoNumber::create)
                .toList()
        );
    }
}
