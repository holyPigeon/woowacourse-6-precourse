package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {

    }

    public static List<Integer> generateRandomNumbers() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(set);
    }
}
