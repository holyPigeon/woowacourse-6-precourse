package christmas.view;

import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderedMenuResponse;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printIntroductionMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPreviewIntroductionMessage() {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", 26);
    }

    public static void printOrderedMenusMessage(List<OrderedMenuResponse> orderedMenus) {
        System.out.println();
        orderedMenus.forEach(orderedMenu -> System.out.printf("%s %d개", orderedMenu.getName(), orderedMenu.getQuantity()));
    }

    public static void printInitialPriceMessage(int initialPrice) {
        System.out.println();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("%s원", decimalFormat.format(initialPrice));
    }

    public static void printGiftMenusMessage(List<GiftMenuResponse> giftMenus) {
        System.out.println();
        giftMenus.forEach(giftMenu -> System.out.printf("%s %d개", giftMenu.getName(), giftMenu.getQuantity()));
    }

    public static void printAvailableDiscountsMessage(List<AvailableDiscountResponse> availableDiscounts) {
        System.out.println();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        availableDiscounts.forEach(availableDiscount -> System.out.printf("%s: -%s", availableDiscount.getName(), decimalFormat.format(availableDiscount.getDiscountAmount())));
    }

    public static void printDiscountAmountMessage(int discountAmount) {
        System.out.println();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("-%s원", decimalFormat.format(discountAmount));
    }

    public static void printDiscountedPriceMessage(int discountedPrice) {
        System.out.println();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("%s원", decimalFormat.format(discountedPrice));
    }
}
