package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.domain.dto.WinningResult;
import lotto.domain.util.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    private LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController create(InputView inputView, OutputView outputView) {
        return new LottoController(inputView, outputView);
    }

    public void run() {
        // 로또 구입금액 입력
        Integer purchaseAmount = readWithExceptionHandling(() -> inputView.readPurchaseAmount());

        // 발행된 로또 목록 출력
        int purchasedLottoCount = purchaseAmount / 1000;
        outputView.printPurchasedLottoCount(purchasedLottoCount);

        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto randomLotto = Lotto.create(RandomLottoNumbersGenerator.generateRandomLottoNumbers());
            winningLottos.add(randomLotto);
            outputView.printGeneratedLotto(randomLotto);
        }

        // 사용자 당첨 번호 입력
        Lotto playerLotto = Lotto.create(readWithExceptionHandling(() -> inputView.readPlayerLotto()));
        // 사용자 보너스 번호 입력
        LottoNumber playerBonusNumber = LottoNumber.create(readWithExceptionHandling(() -> inputView.readBonusNumber()));

        // 로또 서비스 생성
        LottoService lottoService = LottoService.create(Lottos.create(winningLottos), playerLotto, playerBonusNumber);

        // 당첨 통계 출력
        WinningResult winningResult = lottoService.generateWinningResult();
        String winningResultString = winningResult.toString();
        double profitRate = lottoService.calculateProfitRate(winningResult, purchaseAmount);
        outputView.printWinningResult(winningResultString, profitRate);
    }

    private static <T> T readWithExceptionHandling(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
