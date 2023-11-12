package christmas.domain.order;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.menu.Quantity;
import christmas.validator.OrderValidator;

import java.util.EnumMap;
import java.util.Map;

public class Order {

    Map<Menu, Quantity> customerMenus = new EnumMap<>(Menu.class);

    public Order(Map<Menu, Quantity> customerMenus) {
        validate(customerMenus);
        this.customerMenus = customerMenus;
    }

    private void validate(Map<Menu, Quantity> customerMenus) {
        OrderValidator.validateHasDuplicateMenu(customerMenus);
        OrderValidator.validateHasOnlyDrink(customerMenus);
        OrderValidator.validateIsTotalQuantityValid(customerMenus);
    }
}
