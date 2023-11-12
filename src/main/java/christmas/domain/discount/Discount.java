package christmas.domain.discount;

import christmas.Menu;
import christmas.domain.Date;
import christmas.domain.Quantity;

import java.util.Map;

public interface Discount {

    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Date date);

    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Date date);
}
