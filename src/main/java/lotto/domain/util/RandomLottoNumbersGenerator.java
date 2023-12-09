package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoNumber;

import java.util.List;

public class RandomLottoNumbersGenerator {

    private RandomLottoNumbersGenerator() {

    }

    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return randomNumbers.stream()
                .toList();
    }
}
