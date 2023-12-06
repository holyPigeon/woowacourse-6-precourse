package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {

    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
