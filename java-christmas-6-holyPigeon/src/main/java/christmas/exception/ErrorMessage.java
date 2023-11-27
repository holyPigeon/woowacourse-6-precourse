package christmas.exception;

public enum ErrorMessage {

    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    INPUT_IS_BLANK("입력값은 비어있지 않아야 합니다."),

    ORDER_INPUT_REGEX("^([가-힣A-Za-z0-9]+-\\d+)(,[가-힣A-Za-z0-9]+-\\d+)*$");  // 티본스테이크-1,바비큐립-1

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
