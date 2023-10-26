package lotto.view;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printGeneratedLottoCountMessage(int count) {
        System.out.println(8 + "개를 구매했습니다.");
    }

    public void printGeneratedLottoNumberMessage(List<Integer> numberList) {
        System.out.println(numberList.toString());
    }

    public void printLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}