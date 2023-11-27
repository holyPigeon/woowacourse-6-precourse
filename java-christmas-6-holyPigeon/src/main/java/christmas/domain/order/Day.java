package christmas.domain.order;

import christmas.validator.OrderValidator;

import java.util.Objects;

public class Day {

    private final Integer day;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day1 = (Day) o;
        return Objects.equals(day, day1.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    public Integer getPrimitiveDay() {
        return day;
    }
}
