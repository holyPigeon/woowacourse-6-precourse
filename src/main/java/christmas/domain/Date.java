package christmas.domain;

public class Date {

    private Integer date;

    public Date(Integer date) {
        validate(date);
        this.date = date;
    }

    private void validate(Integer date) {
        validateIsDateInRange(date);
    }

    private void validateIsDateInRange(Integer date) {
        if (isNumberInRange(date)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isNumberInRange(Integer number) {
        return number < 1  || number > 31;
    }

    public Integer getDate() {
        return date;
    }
}
