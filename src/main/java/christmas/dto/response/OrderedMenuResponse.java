package christmas.dto.response;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;

public class OrderedMenuResponse {

    private String name;
    private int quantity;

    private OrderedMenuResponse(Menu menu, Quantity quantity) {
        this.name = menu.getName();
        this.quantity = quantity.getPrimitiveQuantity();
    }

    public static OrderedMenuResponse of(Menu menu, Quantity quantity) {
        return new OrderedMenuResponse(menu, quantity);
    }
}
