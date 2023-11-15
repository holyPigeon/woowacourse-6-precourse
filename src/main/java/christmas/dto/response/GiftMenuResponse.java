package christmas.dto.response;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;

public class GiftMenuResponse {

    private final String name;

    private final int quantity;

    private GiftMenuResponse(Menu menu, Quantity quantity) {
        this.name = menu.getName();
        this.quantity = quantity.getPrimitiveQuantity();
    }

    public static GiftMenuResponse of(Menu menu, Quantity quantity) {
        return new GiftMenuResponse(menu, quantity);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
