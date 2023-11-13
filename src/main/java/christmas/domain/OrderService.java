package christmas.domain;

import christmas.domain.discount.DiscountManager;
import christmas.domain.order.Day;
import christmas.domain.order.Order;

public class OrderService {

    private final DiscountManager discountManager;

    private OrderService(Order order, Day day) {
        this.discountManager = DiscountManager.create(order, day);
    }

    public static OrderService create(Order order, Day day) {
        return new OrderService(order, day);
    }
}
