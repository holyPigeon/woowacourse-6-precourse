package christmas.domain.discount;

import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("할인 관리 테스트")
class DiscountManagerTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    DiscountManager discountManager;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-2,아이스크림-2";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        discountManager = DiscountManager.create(order, day);
    }

    @Test
    @DisplayName("주어진 메뉴와 날짜에 따른 총혜택 금액을 반환한다.")
    void return_discount_amount_when_order_and_day_is_given() {
        // when
        int discountAmount = discountManager.calculateDiscountAmount();

        // then
        /*
        디데이 할인 1200원
        스페셜 할인 1000원
        주말 메인메뉴 할인 2023 * 2 = 4046원
        총합 2200 + 4046 = 6246원
         */
        Assertions.assertThat(discountAmount).isEqualTo(6246);
    }

    @Test
    @DisplayName("주어진 메뉴와 날짜에 따른 할인 금액을 반환한다.")
    void return_actual_discount_amount_when_order_and_day_is_given() {
        // when
        int discountAmount = discountManager.calculateActualDiscountAmount();

        // then
        Assertions.assertThat(discountAmount).isEqualTo(6246);
    }

    @Test
    @DisplayName("주어진 메뉴와 날짜에 따른 증정 할인 포함 여부를 반환한다.")
    void return_that_discounts_contains_gift_discount_when_order_and_day_is_given() {
        // when
        boolean hasGiftDiscount = discountManager.hasGiftDiscount();

        // then
        Assertions.assertThat(hasGiftDiscount).isEqualTo(false);
    }
}