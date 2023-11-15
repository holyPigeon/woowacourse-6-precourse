package christmas.domain;

import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("혜택 서비스 테스트")
class PromotionServiceTest {

    List<OrderRequest> orderRequests;
    Order order;
    Day day;
    PromotionService promotionService;

    @BeforeEach
    void setUp() {
        //given
        String orderInput = "해산물파스타-2,아이스크림-2";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
        day = Day.create(3);
        promotionService = PromotionService.create(order, day);
    }

    @Test
    @DisplayName("총구매 금액과 할인 금액이 주어졌을 때, 할인이 적용된 최종 금액을 반환한다.")
    void return_discounted_price_when_initial_price_and_discount_amount_is_given() {
        // given
        int initialPrice = order.calculateInitialPrice();
        int discountAmount = promotionService.calculateActualDiscountAmount();
        int discountedPrice = initialPrice - discountAmount;

        // when
        int calculatedDiscountedPrice = promotionService.calculateDiscountedPrice();

        // then
        Assertions.assertThat(calculatedDiscountedPrice).isEqualTo(discountedPrice);
    }
}