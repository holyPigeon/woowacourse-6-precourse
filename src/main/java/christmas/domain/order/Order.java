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
import java.util.Objects;

public class Order {

    Map<Menu, Quantity> Order;

    private Order(List<OrderRequest> orderRequests) {
        Map<Menu, Quantity> order = InputUtil.parseOrderRequests(orderRequests);
        validate(order);
        this.Order = new EnumMap<>(order);
    }

    public static Order create(List<OrderRequest> orderRequests) {
        return new Order(orderRequests);
    }

    private void validate(Map<Menu, Quantity> order) {
        OrderValidator.validateHasOnlyDrink(order);
        OrderValidator.validateIsTotalQuantityValid(order);
    }

    public List<OrderResponse> findOrderResponses() {
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

    private int getMenuPrice(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getPrice();
    }

    private Integer getEachQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getOrder(), order.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder());
    }

    public Map<Menu, Quantity> getOrder() {
        return new EnumMap<>(Order);
    }
}
