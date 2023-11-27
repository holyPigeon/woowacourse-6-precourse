package christmas.domain.discount.discounts;

import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("증정 이벤트 테스트")
class GiftDiscountTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    GiftDiscount giftDiscount;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-4";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        giftDiscount = GiftDiscount.of(order, day);
    }

    @Test
    @DisplayName("주문과 날짜 정보가 주어졌을 때, 할인 금액을 설정한다.")
    void return_discount_amount_when_order_and_day_is_given() {
        // given
        int giftDiscountAmount = Menu.getGiftMenus()
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue().getPrimitiveQuantity())
                .sum();

        // when
        giftDiscount.calculateDiscountAmount(order, day);

        // then
        assertThat(giftDiscount.getDiscountAmount()).isEqualTo(giftDiscountAmount);
    }

    @ParameterizedTest
    @DisplayName("총주문 금액이 120,000원을 넘었을 때, 할인 가능하다.")
    @ValueSource(ints = {1, 4, 9, 15, 25})
    void return_is_discount_available_when_order_and_day_is_given(int day) {
        // when
        giftDiscount.checkIsAvailableDiscount(order, Day.create(day));

        // then
        assertThat(giftDiscount.getIsAvailable()).isEqualTo(true);
    }
}