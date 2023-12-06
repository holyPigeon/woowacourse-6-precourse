package baseball.domain;

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


}
