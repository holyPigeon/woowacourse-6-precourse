package christmas.util;

import christmas.domain.order.Day;

import java.time.LocalDate;

public class DateUtil {

    private DateUtil() {

    }

    public static LocalDate convertDayToLocalDate(Day day) {
        return LocalDate.of(2023, 12, day.getPrimitiveDay());
    }
}
