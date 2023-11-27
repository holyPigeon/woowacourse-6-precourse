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

@DisplayName("특별 할인 테스트")
class SpecialDiscountTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    SpecialDiscount specialDiscount;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-4";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        specialDiscount = SpecialDiscount.of(order, day);
    }

    @Test
    @DisplayName("주문과 날짜 정보가 주어졌을 때, 할인 금액을 설정한다.")
    void return_discount_amount_when_order_and_day_is_given() {
        // given
        int specialDiscountAmount = 1000;

        // when
        specialDiscount.calculateDiscountAmount(order, day);

        // then
        assertThat(specialDiscount.getDiscountAmount()).isEqualTo(specialDiscountAmount);
    }

    @ParameterizedTest
    @DisplayName("매주 일요일과 크리스마스 당일에 할인 가능하다.")
    @ValueSource(ints = {3, 10, 17, 25, 31})
    void return_is_discount_available_when_order_and_day_is_given(int day) {
        // when
        specialDiscount.checkIsAvailableDiscount(order, Day.create(day));

        // then
        assertThat(specialDiscount.getIsAvailable()).isEqualTo(true);
    }
}