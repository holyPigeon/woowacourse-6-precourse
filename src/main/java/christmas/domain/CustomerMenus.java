package christmas.domain;

import christmas.Menu;

import java.util.EnumMap;
import java.util.Map;

public class CustomerMenus {

    Map<Menu, Integer> customerMenus = new EnumMap<>(Menu.class);

    public CustomerMenus(Map<Menu, Integer> customerMenus) {
        this.customerMenus = customerMenus;
    }
}
