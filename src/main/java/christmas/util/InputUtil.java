package christmas.util;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.request.CustomerMenuRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class InputUtil {

    private InputUtil() {

    }

    public static List<CustomerMenuRequest> parseCustomerMenus(String input) {
        return getEachNameAndQuantity(input)
                .map(parts -> CustomerMenuRequest.of(parts[0], Integer.parseInt(parts[1])))
                .toList();
    }

    private static Stream<String[]> getEachNameAndQuantity(String input) {
        return getEachMenu(input)
                .map(item -> item.split("-"));
    }

    private static Stream<String> getEachMenu(String input) {
        return Arrays.stream(input.split(","));
    }
}
