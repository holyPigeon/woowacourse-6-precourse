package christmas.validator;

import christmas.domain.order.menu.Menu;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import christmas.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private InputValidator() {

    }

    /*
    식당 예상 방문 날짜 입력값 검증
     */
    public static void validateEstimatedVisitingDateInput(String input) {
        validateIsBlank(input);
        validateIsDigit(input);
    }

    /*
    주문 메뉴 및 개수 입력값 전체 검증
     */
    public static void validateOrder(String input) {
        validateOrderInput(input);
        validateOrderRequest(input);
    }

    /*
    주문 메뉴 및 개수 입력값 분리 전 검증
     */
    private static void validateOrderInput(String input) {
        validateIsBlank(input);
        validateIsRightFormat(input);
    }

    private static void validateIsRightFormat(String input) {
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isRightFormat(String input) {
        String regex = ErrorMessage.ORDER_INPUT_REGEX.getMessage();
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    /*
    주문 메뉴 및 개수 입력값 분리 후 검증
     */
    private static void validateOrderRequest(String input) {
        List<OrderRequest> orderRequests = InputUtil.parseOrder(input);
        validateIsExistingMenu(orderRequests);
        validateHasDuplicatedMenu(orderRequests);
    }

    private static void validateIsExistingMenu(List<OrderRequest> orderRequests) {
        if (!isExistingMenu(orderRequests)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isExistingMenu(List<OrderRequest> orderRequests) {
        List<String> menuNames = getMenuNames();
        return orderRequests.stream()
                .map(OrderRequest::getMenuName)
                .allMatch(menuNames::contains);
    }

    private static List<String> getMenuNames() {
        return Arrays.stream(Menu.values())
                .map(Menu::getName)
                .toList();
    }

    private static void validateHasDuplicatedMenu(List<OrderRequest> orderRequests) {
        if (hasDuplicatedMenu(orderRequests)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean hasDuplicatedMenu(List<OrderRequest> orderRequests) {
        return orderRequests.stream()
                .map(OrderRequest::getMenuName)
                .distinct()
                .count() != orderRequests.size();
    }

    /*
    공통 검증
     */
    private static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_BLANK.getMessage());
        }
    }

    private static void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    private static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
