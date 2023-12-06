package baseball.domain;

import java.util.Objects;

public class Hint {

    private int strike;
    private int ball;

    private Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Hint create(int strike, int ball) {
        return new Hint(strike, ball);
    }

    public String getHintMessage() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        String hintMessage = "";

        if (ball != 0) {
            hintMessage += ball + "볼 ";
        }
        if (strike != 0) {
            hintMessage += strike + "스트라이크";
        }
        return hintMessage;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hint hint = (Hint) o;
        return strike == hint.strike && ball == hint.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
