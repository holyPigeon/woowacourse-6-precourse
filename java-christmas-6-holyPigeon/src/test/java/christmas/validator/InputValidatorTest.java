package christmas.validator;

import christmas.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 검증 테스트")
class InputValidatorTest {

    @Test
    @DisplayName("빈 문자열이 날짜 입력값으로 주어졌을 때 예외를 반환한다.")
    void throw_exception_when_empty_day_input_is_given() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateEstimatedVisitingDateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INPUT_IS_BLANK.getMessage()
                );
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 날짜 입력값이 주어졌을 때 예외를 반환한다.")
    @CsvSource({"가", "+", "bear", "!", "a"})
    void throw_exception_when_given_day_input_is_not_digit(String input) {
        // when, then
        assertThatThrownBy(() -> InputValidator.validateEstimatedVisitingDateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_DATE.getMessage()
                );
    }

    @Test
    @DisplayName("빈 문자열이 주문 입력값으로 주어졌을 때 예외를 반환한다.")
    void throw_exception_when_given_order_input_is_not_digit() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INPUT_IS_BLANK.getMessage()
                );
    }

    @ParameterizedTest
    @DisplayName("정해진 포맷에 맞지 않은 주문 입력값이 주어졌을 때 예외를 반환한다.")
    @CsvSource({"레드와인2", "레드와인:2", "레드와인-a", "레드와인:a", "2:레드와인", "2-레드와인", "레드와인--2", "레드와인-티본스테이크"})
    void throw_exception_when_given_order_input_is_invalid_format(String input) {
        // when, then
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }

    @Test
    @DisplayName("목록에 없는 메뉴가 주문 입력값으로 주어졌을 때 예외를 반환한다.")
    void throw_exception_when_given_order_input_has_not_existing_menu() {
        // given
        String input = "피자-2";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }

    @Test
    @DisplayName("중복된 메뉴가 주문 입력값으로 주어졌을 때 예외를 반환한다.")
    void throw_exception_when_given_order_input_has_duplicated_menu() {
        // given
        String input = "레드와인-1,레드와인-3";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }
}