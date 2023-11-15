package christmas.controller;

import christmas.domain.PreviewService;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.response.DiscountPreviewResponse;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class PreviewController {

    private PreviewController() {

    }

    public static PreviewController create() {
        return new PreviewController();
    }


    public void run() {
        printIntroductionMessage();

        Day day = readWithExceptionHandling(PreviewController::readDay);
        Order order = readWithExceptionHandling(PreviewController::readOrder);
        PreviewService previewService = PreviewService.create(order, day);
        closeRead();

        printDiscountPreviewMessage(previewService);
    }

    private static Day readDay() throws IllegalArgumentException {
        return Day.create(InputView.readEstimatedVisitingDate());
    }

    private static Order readOrder() throws IllegalArgumentException {
        return Order.create(InputView.readOrder());
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

    private static void closeRead() {
        InputView.closeRead();
    }

    private static void printIntroductionMessage() {
        OutputView.printIntroductionMessage();
    }

    private static void printDiscountPreviewMessage(PreviewService previewService) {
        OutputView.printDiscountPreviewMessage(DiscountPreviewResponse.from(previewService));
    }
}
