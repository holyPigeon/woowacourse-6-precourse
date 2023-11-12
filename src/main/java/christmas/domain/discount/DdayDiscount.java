package christmas.domain.discount;

import christmas.Menu;
import christmas.domain.Day;
import christmas.domain.Quantity;

import java.util.Map;

public class DdayDiscount implements Discount{
    @Override
    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day) {
        if (isAvailableDiscount(customerMenus, day)) {
            return 1000 + 100 * (day.getDate() - 1);
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Day day) {
        return day.getDate() >= 1 && day.getDate() <= 25;
    }
}
