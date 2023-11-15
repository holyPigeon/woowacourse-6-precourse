package christmas.dto.response;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;

public class OrderResponse {

    private final String name;
    private final int quantity;

    private OrderResponse(Menu menu, Quantity quantity) {
        this.name = menu.getName();
        this.quantity = quantity.getPrimitiveQuantity();
    }

    public static OrderResponse of(Menu menu, Quantity quantity) {
        return new OrderResponse(menu, quantity);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
