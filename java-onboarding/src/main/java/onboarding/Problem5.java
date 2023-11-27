package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getSolution(money);
    }

    public static List<Integer> getSolution(int input) {
        try {
            validateInputRange(input);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR -> " + exception.getMessage());
        }

        return getMoneyCountList(input);
    }

    public static List<Integer> getMoneyCountList(int input) {
        List<Integer> result = new ArrayList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i=0; i<units.length; i++) {
            int count = input / units[i];
            result.add(count);
            input %= units[i];
        }

        return result;
    }

    public static void validateInputRange(int input) {
        if (input < 1 || input > 1000000) {
            throw new IllegalArgumentException("입력값은 1 이상 1,000,000 이하인 자연수이어야 합니다.");
        }
    }
}
