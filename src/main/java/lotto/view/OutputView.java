package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {

    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printPurchasedLottoCount(Integer purchasedLottoCount) {
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");
    }

    public void printGeneratedLotto(Lotto lotto) {
        String result = lotto.getNumbers().stream()
                .map(lottoNumber -> lottoNumber.getNumber().toString())
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.print(result);
    }

    public void printWinningResult(String winningResult, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winningResult);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
