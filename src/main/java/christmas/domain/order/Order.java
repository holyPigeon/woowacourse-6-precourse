package christmas.domain.order;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.response.OrderedMenuResponse;
import christmas.validator.OrderValidator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Order {

    Map<Menu, Quantity> customerMenus = new EnumMap<>(Menu.class);

    private Order(Map<Menu, Quantity> customerMenus) {
        validate(customerMenus);
        this.customerMenus = customerMenus;
    }

    public static Order create(Map<Menu, Quantity> customerMenus) {
        return new Order(customerMenus);
    }

    private void validate(Map<Menu, Quantity> customerMenus) {
        OrderValidator.validateHasDuplicateMenu(customerMenus);
        OrderValidator.validateHasOnlyDrink(customerMenus);
        OrderValidator.validateIsTotalQuantityValid(customerMenus);
    }

    public List<OrderedMenuResponse> findOrderedMenus() {
        return customerMenus
                .entrySet()
                .stream()
                .map(entry -> OrderedMenuResponse.of(entry.getKey(), entry.getValue()))
                .toList();
    }

    public int calculateInitialPrice() {
        return customerMenus
                .entrySet()
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

    public Map<Menu, Quantity> getCustomerMenus() {
        return new EnumMap<>(customerMenus);
    }
}
