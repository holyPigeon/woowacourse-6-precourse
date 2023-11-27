package christmas.domain.discount;

import christmas.domain.order.Day;
import christmas.domain.order.Order;

public interface Discount {

    public void calculateDiscountAmount(Order order, Day day);

    public void checkIsAvailableDiscount(Order order, Day day);

    public String getName();

    public int getDiscountAmount();

    public boolean getIsAvailable();

}
