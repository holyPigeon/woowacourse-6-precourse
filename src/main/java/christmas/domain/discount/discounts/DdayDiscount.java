package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;

public class DdayDiscount implements Discount {

    private final String name = "크리스마스 디데이 할인";

    @Override
    public int calculateDiscountAmount(Order order, Day day) {
        if (isAvailableDiscount(order, day)) {
            return 1000 + 100 * (day.getPrimitiveDay() - 1);
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Order order, Day day) {
        return day.getPrimitiveDay() >= 1 && day.getPrimitiveDay() <= 25;
    }

    public String getName() {
        return name;
    }
}
