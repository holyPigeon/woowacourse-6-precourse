package racingcar.view;

public class OutputView {

    private OutputView() {

    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printRaceResultMessage() {
        System.out.println("실행 결과");
    }

    public void printMovementResult(String movementResult) {
        System.out.println(movementResult);
        System.out.println();
    }
}
