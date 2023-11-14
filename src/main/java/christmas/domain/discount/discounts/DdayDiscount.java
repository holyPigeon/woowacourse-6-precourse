package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;

public class DdayDiscount implements Discount {

    private final String name = "크리스마스 디데이 할인";
    private int discountAmount = 0;
    private boolean isAvailable = false;

    private DdayDiscount(Order order, Day day) {
        checkIsAvailableDiscount(order, day);
        calculateDiscountAmount(order, day);
    }

    public static DdayDiscount of(Order order, Day day) {
        return new DdayDiscount(order, day);
    }

    @Override
    public void calculateDiscountAmount(Order order, Day day) {
        if (isAvailable) {
            discountAmount = 1000 + 100 * (day.getPrimitiveDay() - 1);
        }
    }

    @Override
    public void checkIsAvailableDiscount(Order order, Day day) {
        isAvailable = isEventPeriod(day) && isValidPrice(order);
    }

    private static boolean isEventPeriod(Day day) {
        return day.getPrimitiveDay() >= 1 && day.getPrimitiveDay() <= 25;
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
