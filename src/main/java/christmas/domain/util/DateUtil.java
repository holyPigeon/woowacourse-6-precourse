package christmas.domain.util;

import christmas.domain.Day;

import java.time.LocalDate;

public class DateUtil {

    private DateUtil() {

    }

    public static LocalDate convertDayToLocalDate(Day day) {
        return LocalDate.of(2023, 12, day.getDay());
    }
}
