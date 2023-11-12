package christmas.domain;

public class Quantity {

    private Integer quantity;

    public Quantity(Integer quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(Integer quantity) {
        validateIsGreaterThanCondition(quantity);
    }

    private void validateIsGreaterThanCondition(Integer quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
