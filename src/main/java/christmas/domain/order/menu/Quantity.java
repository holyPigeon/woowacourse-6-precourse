package christmas.domain.order.menu;

import christmas.validator.OrderValidator;

public class Quantity {

    private Integer quantity;

    public Quantity(Integer quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(Integer quantity) {
        OrderValidator.validateIsGreaterThanCondition(quantity);
    }

    public Integer getPrimitiveQuantity() {
        return quantity;
    }
}
