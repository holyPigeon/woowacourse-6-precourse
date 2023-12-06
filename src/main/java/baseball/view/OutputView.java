package baseball.view;

public class OutputView {

    private OutputView() {

    }

    private static OutputView create() {
        return new OutputView();
    }

    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
