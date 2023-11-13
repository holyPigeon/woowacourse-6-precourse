package christmas.domain.order;

import christmas.validator.OrderValidator;

public class Day {

    private Integer day;

    private Day(Integer day) {
        validate(day);
        this.day = day;
    }

    public static Day create(Integer day) {
        return new Day(day);
    }

    private void validate(Integer day) {
        OrderValidator.validateIsDateInRange(day);
    }

    public Integer getPrimitiveDay() {
        return day;
    }
}
