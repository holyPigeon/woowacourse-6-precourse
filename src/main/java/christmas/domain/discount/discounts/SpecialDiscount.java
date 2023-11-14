package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.util.DateUtil;

import java.time.LocalDate;

public class SpecialDiscount implements Discount {

    private final String name = "특별 할인";
    private int discountAmount = 0;
    private boolean isAvailable = false;

    private SpecialDiscount(Order order, Day day) {
        checkIsAvailableDiscount(order, day);
        calculateDiscountAmount(order, day);
    }

    public static SpecialDiscount of(Order order, Day day) {
        return new SpecialDiscount(order, day);
    }

    @Override
    public void calculateDiscountAmount(Order order, Day day) {
        if (isAvailable) {
            discountAmount = 1000;
        }
    }

    @Override
    public void checkIsAvailableDiscount(Order order, Day day) {
        isAvailable = (isSunday(day) || isChristmasDay(day)) && isValidPrice(order) ;
    }

    private boolean isSunday(Day day) {
        LocalDate localDate = DateUtil.convertDayToLocalDate(day);
        return localDate.getDayOfWeek().getValue() == 7; // 1: Monday, 2: Tuesday, ..., 7: Sunday
    }

    private boolean isChristmasDay(Day day) {
        return day.getPrimitiveDay() == 25;
    }

    private static boolean isValidPrice(Order order) {
        return order.calculateInitialPrice() > 10000;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

}
