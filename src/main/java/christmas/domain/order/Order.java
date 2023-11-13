package christmas.domain.order;

import christmas.domain.order.menu.Menu;
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

    public int calculateInitialPrice() {
        return customerMenus.entrySet()
                .stream()
                .mapToInt(entry -> getMenuPrice(entry) * getEachQuantity(entry))
                .sum();
    }

    private Integer getEachQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    private int getMenuPrice(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getPrice();
    }

    public Badge calculateBadge() {
        return Badge.calculateBadge(calculateInitialPrice());
    }
}
