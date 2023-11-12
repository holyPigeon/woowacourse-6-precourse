package christmas.domain.discount;

import christmas.Menu;
import christmas.domain.Day;
import christmas.domain.Quantity;

import java.util.Map;

public interface Discount {

    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day);

    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Day day);
}
