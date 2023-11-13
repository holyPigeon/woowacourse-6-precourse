package christmas.domain.discount;

import christmas.domain.order.Day;
import christmas.domain.order.Order;

public interface Discount {

    public int calculateDiscountAmount(Order order, Day day);

    public boolean isAvailableDiscount(Order order, Day day);

    public String getName();
}
