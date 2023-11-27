package christmas.validator;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.OrderRequest;
import christmas.exception.ErrorMessage;
import christmas.util.InputUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("주문 관련 비즈니스 검증 테스트")
class OrderValidatorTest {

    @Test
    @DisplayName("주문 입력값이 음료 메뉴만을 포함할 때, 예외를 반환한다.")
    void throw_exception_when_order_input_has_only_drink() {
        // given
        String input = "레드와인-1,제로콜라-3";
        List<OrderRequest> orderRequests = InputUtil.parseOrder(input);
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);

        // when, then
        assertThatThrownBy(() -> OrderValidator.validateHasOnlyDrink(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }

    @Test
    @DisplayName("주문 입력값 상의 주문한 메뉴의 개수가 기준값을 넘어가면, 예외를 반환한다.")
    void throw_exception_when_order_input_has_menu_greater_than_condition() {
        // given
        String input = "레드와인-15,제로콜라-12";
        List<OrderRequest> orderRequests = InputUtil.parseOrder(input);
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);

        // when, then
        assertThatThrownBy(() -> OrderValidator.validateIsTotalQuantityValid(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }

    @Test
    @DisplayName("주문 입력값 중 개수가 기준 이하인 메뉴가 있다면, 예외를 반환한다.")
    void throw_exception_when_order_input_has_menu_which_has_quantity_less_than_condition() {
        // given
        Integer primitiveQuantity = 0;

        // when, then
        assertThatThrownBy(() -> OrderValidator.validateIsEachQuantityGreaterThanCondition(primitiveQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.INVALID_ORDER.getMessage()
                );
    }
}