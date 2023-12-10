package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumbersGenerator {

    private RandomLottoNumbersGenerator() {

    }

    public static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }
}
