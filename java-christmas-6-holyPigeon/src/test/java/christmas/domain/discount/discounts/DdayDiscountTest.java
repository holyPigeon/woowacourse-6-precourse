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

@DisplayName("크리스마스 디데이 할인 테스트")
class DdayDiscountTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    DdayDiscount ddayDiscount;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-2,아이스크림-2";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        ddayDiscount = DdayDiscount.of(order, day);
    }

    @Test
    @DisplayName("주문과 날짜 정보가 주어졌을 때, 할인 금액을 설정한다.")
    void return_discount_amount_when_order_and_day_is_given() {
        // when
        ddayDiscount.calculateDiscountAmount(order, day);

        // then
        assertThat(ddayDiscount.getDiscountAmount()).isEqualTo(1200);
    }

    @ParameterizedTest
    @DisplayName("주문과 날짜 정보가 주어졌을 때, 할인 가능 여부를 설정한다.")
    @ValueSource(ints = {1, 4, 9, 15, 25})
    void return_is_discount_available_when_order_and_day_is_given(int day) {
        // when
        ddayDiscount.checkIsAvailableDiscount(order, Day.create(day));

        // then
        assertThat(ddayDiscount.getIsAvailable()).isEqualTo(true);
    }
}