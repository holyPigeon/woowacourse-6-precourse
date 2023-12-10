package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printPurchasedLottoCount(Integer purchasedLottoCount) {
        System.out.println();
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public void printGeneratedLotto(Lotto lotto) {
        List<Integer> list = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList();

        System.out.println(list);
    }

    public void printWinningResult(String winningResult, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winningResult);
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
