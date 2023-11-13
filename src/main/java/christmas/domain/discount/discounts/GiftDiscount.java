package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.Day;
import christmas.domain.order.menu.Quantity;

import java.util.Map;

public class GiftDiscount implements Discount {

    private final String name = "증정 이벤트";

    @Override
    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day) {
        if (isAvailableDiscount(customerMenus, day)) {
            return 25000;
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Day day) {
        return calculateTotalPrice(customerMenus) >= 120000;
    }

    private static int calculateTotalPrice(Map<Menu, Quantity> customerMenus) {
        return customerMenus.entrySet()
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
