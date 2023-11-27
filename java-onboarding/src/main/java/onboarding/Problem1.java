package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return getSolution(pobi, crong);
    }

    private static int getSolution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 1. 책을 임의로 펼친다. -> pobi, crong 파라미터를 통해 입력값 획득
        // 입력값에 대한 검증 로직
        try {
            validatePage(pobi);
            validatePage(crong);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR -> " + exception.getMessage());
            return -1;
        }

        // 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        // 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        // 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        int pobiScore = getResultScore(pobi);
        int crongScore = getResultScore(crong);

        // 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        answer = getWinPlayer(pobiScore, crongScore);

        return answer;
    }

    private static int getWinPlayer(int score1, int score2) {
        try {
            if (score1 > score2) {
                return 1;
            } else if (score1 < score2) {
                return 2;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    private static int getResultScore(List<Integer> player) {
        int page1 = player.get(0);
        int page2 = player.get(1);

        int maxLeft = Math.max(multiplyEveryNum(page1), addEveryNum(page1));
        int maxRight = Math.max(multiplyEveryNum(page2), addEveryNum(page2));

        return Math.max(maxLeft, maxRight);
    }

    private static void validatePage(List<Integer> player) {
        if (player.get(1) != player.get(0) + 1) {
            throw new IllegalArgumentException("페이지의 순서가 알맞지 않습니다.");
        }
    }

    private static int addEveryNum(int num) {
        int num1 = num % 10;
        int num10 = (num % 100) / 10;
        int num100 = num / 100;

        return num1 + num10 + num100;
    }

    private static int multiplyEveryNum(int num) {
        int num1 = num % 10;
        int num10 = (num % 100) / 10;
        int num100 = num / 100;

        if (num > 10 && num < 100) {
            num100 = 1;
        } else if (num < 10) {
            num100 = 1;
            num10 = 1;
        }

        return num1 * num10 * num100;
    }
}