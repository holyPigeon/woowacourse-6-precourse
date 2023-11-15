package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.request.OrderRequest;
import christmas.util.InputUtil;
import christmas.validator.InputValidator;
import christmas.view.constant.SystemMessage;

import java.util.List;

public class InputView {

    private InputView() {

    }

    public static Integer readEstimatedVisitingDate() {
        System.out.println(SystemMessage.READ_ESTIMATED_VISITING_DATE.getIntroductionMessageWithMonth());
        String input = Console.readLine();
        InputValidator.validateEstimatedVisitingDateInput(input);

        return Integer.parseInt(input);
    }

    public static List<OrderRequest> readOrder() {
        System.out.println(SystemMessage.READ_ORDER.getMessage());
        String input = Console.readLine();
        InputValidator.validateOrder(input);

        return InputUtil.parseOrder(input);
    }

    public static void closeRead() {
        Console.close();
    }
}
