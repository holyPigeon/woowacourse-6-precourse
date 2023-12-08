package lotto.view;

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

    public void printGeneratedLotto(List<Integer> lotto) {
        String result = lotto.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.print(result);
    }
}
