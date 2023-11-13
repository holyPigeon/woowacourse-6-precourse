package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.util.DateUtil;

import java.time.LocalDate;

public class SpecialDiscount implements Discount {

    private final String name = "특별 할인";

    @Override
    public int calculateDiscountAmount(Order order, Day day) {
        if (isAvailableDiscount(order, day)) {
            return 1000;
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Order order, Day day) {
        return isSunday(day) || isChristmasDay(day);
    }

    private boolean isSunday(Day day) {
        LocalDate localDate = DateUtil.convertDayToLocalDate(day);
        return localDate.getDayOfWeek().getValue() == 7; // 1: Monday, 2: Tuesday, ..., 7: Sunday
    }

    private boolean isChristmasDay(Day day) {
        return day.getPrimitiveDay() == 25;
    }

    public String getName() {
        return name;
    }
}
