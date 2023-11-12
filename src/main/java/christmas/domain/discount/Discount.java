package christmas.domain.discount;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.Day;
import christmas.domain.order.menu.Quantity;

import java.util.Map;

public interface Discount {

    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day);

    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Day day);
}
