package christmas.util;

import christmas.config.PromotionConfig;
import christmas.domain.order.Day;

import java.time.LocalDate;

public class DateUtil {

    private DateUtil() {

    }

    public static LocalDate convertDayToLocalDate(Day day) {
        return LocalDate.of(PromotionConfig.YEAR.getNumber(), PromotionConfig.MONTH.getNumber(), day.getPrimitiveDay());
    }
}
