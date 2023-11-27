package christmas.domain.discount.discounts;

import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주말 할인 테스트")
class WeekendDiscountTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    WeekendDiscount weekendDiscount;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-2,아이스크림-2";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        weekendDiscount = WeekendDiscount.of(order, day);
    }

    @Test
    @DisplayName("주문 중의 메인 메뉴 개수와 기준 금액을 곱한 만큼 할인을 적용한다.")
    void return_discount_amount_when_order_and_day_is_given() {
        // given
        int weekendDiscountAmount = 2023 * 2;

        // when
        weekendDiscount.calculateDiscountAmount(order, day);

        // then
        assertThat(weekendDiscount.getDiscountAmount()).isEqualTo(weekendDiscountAmount);
    }

    @ParameterizedTest
    @DisplayName("주말 중이고 주문에 메인 메뉴가 포함되어 있을 경우 할인 가능하다.")
    @ValueSource(ints = {2, 3, 9, 10, 17})
    void return_is_discount_available_when_order_and_day_is_given(int day) {
        // when
        weekendDiscount.checkIsAvailableDiscount(order, Day.create(day));

        // then
        assertThat(weekendDiscount.getIsAvailable()).isEqualTo(true);
    }
}