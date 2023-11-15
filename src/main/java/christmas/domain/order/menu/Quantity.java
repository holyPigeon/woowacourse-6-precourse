package christmas.domain.order.menu;

import christmas.validator.OrderValidator;

import java.util.Objects;

public class Quantity {

    private final Integer quantity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return Objects.equals(quantity, quantity1.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public Integer getPrimitiveQuantity() {
        return quantity;
    }
}
