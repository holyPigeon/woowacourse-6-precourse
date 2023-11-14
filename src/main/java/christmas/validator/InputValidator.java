package christmas.validator;

import christmas.domain.order.menu.Menu;
import christmas.dto.request.CustomerMenuRequest;
import christmas.util.InputUtil;

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

    private static void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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

    /*
    주문 메뉴 및 개수 입력값 전체 검증
     */
    public static void validateCustomerMenus(String input) {
        validateCustomerMenusInput(input);
        validateCustomerMenusRequest(input);
    }

    /*
    주문 메뉴 및 개수 입력값 분리 전 검증
     */
    private static void validateCustomerMenusInput(String input) {
        validateIsBlank(input);
        validateIsRightFormat(input);
    }

    private static void validateIsRightFormat(String input) {
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isRightFormat(String input) {
        String regex = "^([가-힣A-Za-z0-9]+-\\d+)(,[가-힣A-Za-z0-9]+-\\d+)*$"; // 티본스테이크-1,바비큐립-1
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    /*
    주문 메뉴 및 개수 입력값 분리 후 검증
     */
    private static void validateCustomerMenusRequest(String input) {
        List<CustomerMenuRequest> customerMenuRequests = InputUtil.parseCustomerMenus(input);
        validateIsExistingMenu(customerMenuRequests);
        validateHasDuplicatedMenu(customerMenuRequests);
    }

    private static void validateIsExistingMenu(List<CustomerMenuRequest> menuRequests) {
        if (!isExistingMenu(menuRequests)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isExistingMenu(List<CustomerMenuRequest> menuRequests) {
        List<String> menuNames = getMenuNames();
        return menuRequests.stream()
                .map(CustomerMenuRequest::getMenuName)
                .allMatch(menuNames::contains);
    }

    private static List<String> getMenuNames() {
        return Arrays.stream(Menu.values())
                .map(Menu::getName)
                .toList();
    }

    private static void validateHasDuplicatedMenu(List<CustomerMenuRequest> menuRequests) {
        if (hasDuplicatedMenu(menuRequests)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean hasDuplicatedMenu(List<CustomerMenuRequest> menuRequests) {
        return menuRequests.stream()
                .map(CustomerMenuRequest::getMenuName)
                .distinct()
                .count() != menuRequests.size();
    }

    /*
    공통 검증
     */
    private static void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
