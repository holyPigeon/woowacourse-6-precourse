package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Prize {

    NONE(0, false, 0),
    THREE_NUMBER_MATCH(3, false, 5_000),
    FOUR_NUMBER_MATCH(4, false, 50_000),
    FIVE_NUMBER_MATCH(5, false, 1_500_000),
    FIVE_NUMBER_AND_BONUS_NUMBER_MATCH(5, true, 30_000_000),
    SIX_NUMBER_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prizeMoney;

    Prize(int matchCount, boolean hasBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrizeByMatchCountAndBonusNumber(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == 3 && prize.hasBonusNumber == hasBonusNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public String getDecimalFormatPrizeMoney() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prizeMoney);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
