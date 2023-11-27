package christmas.domain.order;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.OrderRequest;
import christmas.dto.response.OrderResponse;
import christmas.util.InputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("주문 테스트")
class OrderTest {

    List<OrderRequest> orderRequests;
    Order order;

    @BeforeEach
    void setUp() {
        // given
        String orderInput = "해산물파스타-2,아이스크림-2";
        orderRequests = InputUtil.parseOrder(orderInput);
        order = Order.create(orderRequests);
    }

    @Test
    @DisplayName("주어진 주문을 바탕으로 주문 Response DTO를 반환한다.")
    void find_order_response_when_order_is_given() {
        // given
        String name1 = orderRequests.get(0).getMenuName();
        int quantity1 = orderRequests.get(0).getQuantity();
        String name2 = orderRequests.get(1).getMenuName();
        int quantity2 = orderRequests.get(1).getQuantity();

        // when
        List<OrderResponse> findOrderResponses = order.findOrderResponses();

        // then
        assertThat(name1).isEqualTo(findOrderResponses.get(0).getName());
        assertThat(quantity1).isEqualTo(findOrderResponses.get(0).getQuantity());
        assertThat(name2).isEqualTo(findOrderResponses.get(1).getName());
        assertThat(quantity2).isEqualTo(findOrderResponses.get(1).getQuantity());
    }

    @Test
    @DisplayName("주어진 주문을 바탕으로 총주문 금액을 계산하여 반환한다.")
    void calculate_initial_price_when_order_is_given() {
        // given
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);
        int price = order.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue().getPrimitiveQuantity())
                .sum();

        // when
        int calculatedPrice = this.order.calculateInitialPrice();

        // then
        assertThat(price).isEqualTo(calculatedPrice);
    }
}