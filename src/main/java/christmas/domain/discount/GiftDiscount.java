package christmas.domain.discount;

import christmas.Menu;
import christmas.domain.Day;
import christmas.domain.Quantity;

import java.util.Map;

public class GiftDiscount implements Discount {
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
        return customerMenus.keySet()
                .stream()
                .mapToInt(Menu::getPrice)
                .sum();
    }
}
