package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Prize {

    NONE(0, 0),
    THREE_NUMBER_MATCH(3, 5_000),
    FOUR_NUMBER_MATCH(4, 50_000),
    FIVE_NUMBER_MATCH(5, 1_500_000),
    FIVE_NUMBER_AND_BONUS_NUMBER_MATCH(6, 30_000_000),
    SIX_NUMBER_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrizeByMatchCountAndBonusNumber(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDecimalFormatPrizeMoney() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prizeMoney);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
