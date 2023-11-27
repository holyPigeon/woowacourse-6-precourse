package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {
        return getSolution(number);
    }

    static int getSolution(int number) {
        try {
            validateNumberRange(number);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR -> " + exception.getMessage());
        }

        return getClapCount(number);
    }

    static int getClapCount(int number) {
        int totalClapCount = 0;

        for (int i = 1; i <= number; i++) {
            totalClapCount += get369Frequency(getDigitNumberList(i));
        }

        return totalClapCount;
    }

    static int get369Frequency(List<Integer> list) {
        int count = 0;

        count += Collections.frequency(list, 3);
        count += Collections.frequency(list, 6);
        count += Collections.frequency(list, 9);

        return count;
    }

    static List<Integer> getDigitNumberList(int number) {
        List<Integer> digitNumberList = new ArrayList<>();
        String strNumber = String.valueOf(number);

        for (int i = 0; i < strNumber.length(); i++) {
            int digit = Character.getNumericValue(strNumber.charAt(i));
            digitNumberList.add(digit);
        }

        return digitNumberList;
    }

    static void validateNumberRange(int number) {
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("입력값은 1 이상 10,000 이하인 자연수이어야 합니다.");
        }
    }
}
