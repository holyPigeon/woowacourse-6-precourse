package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.Day;
import christmas.domain.order.menu.Quantity;

import java.util.Map;

public class GiftDiscount implements Discount {

    private final String name = "증정 이벤트";

    @Override
    public int calculateDiscountAmount(Order order, Day day) {
        if (isAvailableDiscount(order, day)) {
            return Menu.getGiftMenu().getPrice();
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Order order, Day day) {
        return calculateTotalPrice(order) >= 120000;
    }

    private static int calculateTotalPrice(Order order) {
        return order.getCustomerMenus()
                .entrySet()
                .stream()
                .mapToInt(entry -> getMenuPrice(entry) * getEachQuantity(entry))
                .sum();
    }

    private static Integer getEachQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    private static int getMenuPrice(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getPrice();
    }

    public String getName() {
        return name;
    }
}
