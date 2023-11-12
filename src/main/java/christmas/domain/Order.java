package christmas.domain;

import christmas.Menu;

import java.util.EnumMap;
import java.util.Map;

public class Order {

    Map<Menu, Integer> customerMenus = new EnumMap<>(Menu.class);

    public CustomerMenus(Map<Menu, Integer> customerMenus) {
        validate(customerMenus);
        this.customerMenus = customerMenus;
    }

    private void validate(Map<Menu, Integer> customerMenus) {
        validateHasDuplicateMenu(customerMenus);
    }

    private void validateHasDuplicateMenu(Map<Menu, Integer> customerMenus) {
        if (hasDuplicateMenu(customerMenus)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private boolean hasDuplicateMenu(Map<Menu, Integer> customerMenus) {
        return customerMenus.keySet()
                .stream()
                .distinct()
                .count() != customerMenus.size();
    }
}
