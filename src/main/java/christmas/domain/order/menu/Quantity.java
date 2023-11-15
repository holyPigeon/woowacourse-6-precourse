package christmas.domain.order.menu;

import christmas.validator.OrderValidator;

public class Quantity {

    private Integer quantity;

    private Quantity(Integer quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    public static Quantity create(Integer quantity) {
        return new Quantity(quantity);
    }

    private void validate(Integer quantity) {
        OrderValidator.validateIsEachQuantityGreaterThanCondition(quantity);
    }

    public Integer getPrimitiveQuantity() {
        return quantity;
    }
}
