package lotto.domain.dto;

import lotto.domain.Prize;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private final Map<Prize, Integer> winningResult;

    private WinningResult(Map<Prize, Integer> winningResult) {
        this.winningResult = new EnumMap<>(winningResult);
    }

    public static WinningResult create(Map<Prize, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Prize prize : Prize.values()) {
            if (prize.equals(Prize.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH)) {
                result.append(String.format("%s개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        prize.getMatchCount(),
                        prize.getDecimalFormatPrizeMoney(),
                        winningResult.getOrDefault(prize, 0)));
                continue;
            }

            result.append(String.format("%s개 일치 (%s원) - %d개\n",
                    prize.getMatchCount(),
                    prize.getDecimalFormatPrizeMoney(),
                    winningResult.getOrDefault(prize, 0)));
        }

        return result.toString();
    }

    public Map<Prize, Integer> getWinningResult() {
        return new EnumMap<>(winningResult);
    }
}
