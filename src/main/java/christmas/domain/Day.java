package christmas.domain;

public class Day {

    private Integer day;

    public Day(Integer day) {
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) {
        validateIsDateInRange(day);
    }

    private void validateIsDateInRange(Integer day) {
        if (isNumberInRange(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isNumberInRange(Integer number) {
        return number < 1  || number > 31;
    }

    public Integer getPrimitiveDay() {
        return day;
    }
}
