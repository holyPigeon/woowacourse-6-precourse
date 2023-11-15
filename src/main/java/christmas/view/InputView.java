package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import christmas.validator.InputValidator;

import java.util.List;

public class InputView {

    private InputView() {

    }

    public static Integer readEstimatedVisitingDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        InputValidator.validateEstimatedVisitingDateInput(input);

        return Integer.parseInt(input);
    }

    public static List<OrderRequest> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        InputValidator.validateOrder(input);

        return InputUtil.parseOrder(input);
    }
}
