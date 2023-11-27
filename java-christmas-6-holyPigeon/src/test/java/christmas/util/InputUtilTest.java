package christmas.util;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.OrderRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입력값 유틸 기능 테스트")
class InputUtilTest {

    @Test
    @DisplayName("주어진 주문 입력값을 주문 Request DTO 타입 리스트로 파싱하여 반환한다.")
    void return_order_request_type_list_when_input_is_given() {
        // given
        String input = "레드와인-2,티본스테이크-1";

        // when
        List<OrderRequest> orderRequests = InputUtil.parseOrder(input);

        // then
        assertThat(orderRequests.get(0).getMenuName()).isEqualTo("레드와인");
        assertThat(orderRequests.get(0).getQuantity()).isEqualTo(2);
        assertThat(orderRequests.get(1).getMenuName()).isEqualTo("티본스테이크");
        assertThat(orderRequests.get(1).getQuantity()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 주문 Request DTO 타입 리스트를 Enum Map 타입으로 파싱하여 반환한다.")
    void return_enum_map_type_when_order_request_type_list_is_given() {
        // given
        Menu menu1 = Menu.findByName("레드와인");
        Menu menu2 = Menu.findByName("티본스테이크");
        Quantity quantity1 = Quantity.create(2);
        Quantity quantity2 = Quantity.create(1);

        String input = "레드와인-2,티본스테이크-1";
        List<OrderRequest> orderRequests = InputUtil.parseOrder(input);

        // when
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);

        // then
        assertThat(order.containsKey(menu1)).isEqualTo(true);
        assertThat(order.containsKey(menu2)).isEqualTo(true);
        assertThat(order.containsValue(quantity1)).isEqualTo(true);
        assertThat(order.containsValue(quantity2)).isEqualTo(true);
    }
}