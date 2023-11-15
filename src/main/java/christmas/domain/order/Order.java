package christmas.domain.order;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.OrderRequest;
import christmas.dto.response.OrderResponse;
import christmas.util.InputUtil;
import christmas.validator.OrderValidator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Order {

    Map<Menu, Quantity> Order = new EnumMap<>(Menu.class);

    private Order(List<OrderRequest> orderRequests) {
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);
        validate(order);
        this.Order = order;
    }

    public static Order create(List<OrderRequest> orderRequests) {
        return new Order(orderRequests);
    }

    private void validate(Map<Menu, Quantity> order) {
        OrderValidator.validateHasOnlyDrink(order);
        OrderValidator.validateIsTotalQuantityValid(order);
    }

    public List<OrderResponse> findOrderResponse() {
        return Order
                .entrySet()
                .stream()
                .map(entry -> OrderResponse.of(entry.getKey(), entry.getValue()))
                .toList();
    }

    public int calculateInitialPrice() {
        return Order
                .entrySet()
                .stream()
                .mapToInt(entry -> getMenuPrice(entry) * getEachQuantity(entry))
                .sum();
    }

    private Integer getEachQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    private int getMenuPrice(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getPrice();
    }

    public Map<Menu, Quantity> getOrder() {
        return new EnumMap<>(Order);
    }
}
