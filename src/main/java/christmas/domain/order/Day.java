package christmas.domain.order;

import christmas.validator.OrderValidator;

public class Day {

    private Integer day;

    public Day(Integer day) {
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) {
        OrderValidator.validateIsDateInRange(day);
    }

    public Integer getPrimitiveDay() {
        return day;
    }
}
