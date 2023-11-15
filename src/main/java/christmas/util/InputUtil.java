package christmas.util;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.OrderRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtil {

    private InputUtil() {

    }

    public static List<OrderRequest> parseOrder(String input) {
        return getEachNamesAndQuantities(input)
                .map(parts -> OrderRequest.of(parts[0], Integer.parseInt(parts[1])))
                .toList();
    }

    private static Stream<String[]> getEachNamesAndQuantities(String input) {
        return getMenuNamesAndQuantities(input)
                .map(item -> item.split("-"));
    }

    private static Stream<String> getMenuNamesAndQuantities(String input) {
        return Arrays.stream(input.split(","));
    }

    public static Map<Menu, Quantity> parseOrderRequests(List<OrderRequest> orderRequests) {
        return orderRequests.stream()
                .collect(Collectors.toMap(
                        request -> Menu.findByName(request.getMenuName()),
                        request -> Quantity.create(request.getQuantity())
                ));
    }
}
