package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    public List<Integer> generateRandomNumberList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
