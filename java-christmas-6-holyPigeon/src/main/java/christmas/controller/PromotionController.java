package christmas.controller;

import christmas.domain.PromotionService;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.response.DiscountPreviewResponse;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class PromotionController {

    private PromotionController() {

    }

    public static PromotionController create() {
        return new PromotionController();
    }


    public void run() {
        printIntroductionMessage();

        Day day = readWithExceptionHandling(PromotionController::readDay);
        Order order = readWithExceptionHandling(PromotionController::readOrder);
        PromotionService promotionService = PromotionService.create(order, day);
        closeRead();

        printDiscountPreviewMessage(promotionService);
    }

    private static void printIntroductionMessage() {
        OutputView.printIntroductionMessage();
    }

    private static <T> T readWithExceptionHandling(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static Day readDay() throws IllegalArgumentException {
        return Day.create(InputView.readEstimatedVisitingDate());
    }

    private static Order readOrder() throws IllegalArgumentException {
        return Order.create(InputView.readOrder());
    }

    private static void closeRead() {
        InputView.closeRead();
    }

    private static void printDiscountPreviewMessage(PromotionService promotionService) {
        OutputView.printDiscountPreviewMessage(DiscountPreviewResponse.from(promotionService));
    }
}
