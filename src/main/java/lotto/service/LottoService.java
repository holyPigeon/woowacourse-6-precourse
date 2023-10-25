package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoService {

    public Lotto generateLotto(List<Integer> randomNumberList) {
        return new Lotto(randomNumberList);
    }

    public List<Integer> generateRandomNumberList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
