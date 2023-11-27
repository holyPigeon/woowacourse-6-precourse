package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final InputView instance = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

     public String read() {
         return readLine();
     }
}
