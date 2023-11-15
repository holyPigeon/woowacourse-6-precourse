package christmas.view;

import christmas.domain.order.Badge;
import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.DiscountPreviewResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderResponse;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printIntroductionMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDiscountPreviewMessage(DiscountPreviewResponse discountPreviewResponse) {
        printDiscountPreviewIntroductionMessage();
        printOrderMessage(discountPreviewResponse.getOrderResponses());
        printInitialPriceMessage(discountPreviewResponse.getInitialPrice());
        printGiftMenusMessage(discountPreviewResponse.getGiftMenuResponses());
        printAvailableDiscountsMessage(discountPreviewResponse.getAvailableDiscountResponses());
        printDiscountAmountMessage(discountPreviewResponse.getDiscountAmount());
        printDiscountedPriceMessage(discountPreviewResponse.getDiscountedPrice());
        printBadgeMessage(discountPreviewResponse.getBadge());
    }

    public static void printDiscountPreviewIntroductionMessage() {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", 26);
    }

    private static void printOrderMessage(List<OrderResponse> order) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        order.forEach(eachMenu -> System.out.printf("%s %d개%n", eachMenu.getName(), eachMenu.getQuantity()));
    }

    private static void printInitialPriceMessage(int initialPrice) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("%s원%n", decimalFormat.format(initialPrice));
    }

    private static void printGiftMenusMessage(List<GiftMenuResponse> giftMenus) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (giftMenus.size() == 0) {
            System.out.println("없음");
        }
        giftMenus.forEach(giftMenu -> System.out.printf("%s %d개%n", giftMenu.getName(), giftMenu.getQuantity()));
    }

    private static void printAvailableDiscountsMessage(List<AvailableDiscountResponse> availableDiscounts) {
        System.out.println();
        System.out.println("<혜택 내역>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (availableDiscounts.size() == 0) {
            System.out.println("없음");
        }
        availableDiscounts.forEach(availableDiscount -> System.out.printf("%s: -%s%n", availableDiscount.getName(), decimalFormat.format(availableDiscount.getDiscountAmount())));
    }

    private static void printDiscountAmountMessage(int discountAmount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (discountAmount != 0) {
            System.out.printf("-%s원%n", decimalFormat.format(discountAmount));
        }
        if (discountAmount == 0) {
            System.out.printf("%s원%n", decimalFormat.format(discountAmount));
        }

    }

    private static void printDiscountedPriceMessage(int discountedPrice) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("%s원%n", decimalFormat.format(discountedPrice));
    }

    private static void printBadgeMessage(Badge badge) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.print(badge.getName());
    }
}
