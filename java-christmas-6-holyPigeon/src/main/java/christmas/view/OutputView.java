package christmas.view;

import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.DiscountPreviewResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderResponse;
import christmas.view.constant.SystemMessage;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printIntroductionMessage() {
        System.out.println(SystemMessage.INTRODUCTION.getIntroductionMessageWithMonth());
    }

    public static void printDiscountPreviewMessage(DiscountPreviewResponse discountPreviewResponse) {
        printDiscountPreviewIntroductionMessage(discountPreviewResponse.getDay());
        printOrderMessage(discountPreviewResponse.getOrderResponses());
        printInitialPriceMessage(discountPreviewResponse.getInitialPrice());
        printGiftMenusMessage(discountPreviewResponse.getGiftMenuResponses());
        printAvailableDiscountsMessage(discountPreviewResponse.getAvailableDiscountResponses());
        printDiscountAmountMessage(discountPreviewResponse.getDiscountAmount());
        printDiscountedPriceMessage(discountPreviewResponse.getDiscountedPrice());
        printBadgeMessage(discountPreviewResponse.getBadge());
    }

    public static void printDiscountPreviewIntroductionMessage(int day) {
        System.out.println(SystemMessage.DISCOUNT_PREVIEW_INTRODUCTION.getIntroductionMessageWithMonthAndDay(day));
    }

    private static void printOrderMessage(List<OrderResponse> order) {
        System.out.println();
        System.out.println(SystemMessage.ORDER_TITLE.getTitleMessage());
        order.forEach(eachMenu ->
                System.out.print(SystemMessage.ORDER_FORMAT.getOrderMessage(eachMenu)));
    }

    private static void printInitialPriceMessage(int initialPrice) {
        System.out.println();
        System.out.println(SystemMessage.INITIAL_PRICE_TITLE.getTitleMessage());
        System.out.println(SystemMessage.MONEY_FORMAT.getMoneyMessage(initialPrice));
    }

    private static void printGiftMenusMessage(List<GiftMenuResponse> giftMenus) {
        System.out.println();
        System.out.println(SystemMessage.GIFT_MENUS_TITLE.getTitleMessage());
        if (giftMenus.size() == 0) {
            System.out.println(SystemMessage.NONE.getMessage());
        }
        giftMenus.forEach(eachMenu ->
                System.out.print(SystemMessage.ORDER_FORMAT.getGiftMessage(eachMenu)));
    }

    private static void printAvailableDiscountsMessage(List<AvailableDiscountResponse> availableDiscounts) {
        System.out.println();
        System.out.println(SystemMessage.AVAILABLE_DISCOUNTS_TITLE.getTitleMessage());
        if (availableDiscounts.size() == 0) {
            System.out.println(SystemMessage.NONE.getMessage());
        }
        availableDiscounts.forEach(discount ->
                System.out.print(SystemMessage.DISCOUNT_FORMAT.getDiscountMessage(discount)));
    }

    private static void printDiscountAmountMessage(int discountAmount) {
        System.out.println();
        System.out.println(SystemMessage.DISCOUNT_AMOUNT_TITLE.getTitleMessage());
        System.out.println(SystemMessage.MONEY_FORMAT.getDiscountMoneyMessage(discountAmount));
    }

    private static void printDiscountedPriceMessage(int discountedPrice) {
        System.out.println();
        System.out.println(SystemMessage.DISCOUNTED_PRICE_TITLE.getTitleMessage());
        System.out.println(SystemMessage.MONEY_FORMAT.getMoneyMessage(discountedPrice));
    }

    private static void printBadgeMessage(String badge) {
        System.out.println();
        System.out.println(SystemMessage.BADGE_TITLE.getTitleMessage());
        System.out.print(SystemMessage.BADGE_TITLE.getBadgeMessage(badge));
    }
}
