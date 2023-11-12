package christmas.domain.discount;

import christmas.Menu;
import christmas.domain.Date;
import christmas.domain.Quantity;

import java.util.Map;

public class DdayDiscount implements Discount{
    @Override
    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Date date) {
        if (isAvailableDiscount(customerMenus, date)) {
            return 1000 + 100 * (date.getDate() - 1);
        }
        return 0;
    }

    @Override
    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Date date) {
        return date.getDate() >= 1 && date.getDate() <= 25;
    }
}
