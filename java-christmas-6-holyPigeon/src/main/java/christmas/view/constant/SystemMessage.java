package christmas.view.constant;

import christmas.config.PromotionConfig;
import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderResponse;

import java.text.DecimalFormat;

public enum SystemMessage {

    /*
    웰컴 메시지
     */
    INTRODUCTION("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),

    /*
    사용자 입력 메시지
     */
    READ_ESTIMATED_VISITING_DATE("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    /*
    혜택 미리보기 관련 메시지
     */
    DISCOUNT_PREVIEW_INTRODUCTION("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_TITLE("주문 메뉴"),
    INITIAL_PRICE_TITLE("할인 전 총주문 금액"),
    GIFT_MENUS_TITLE("증정 메뉴"),
    AVAILABLE_DISCOUNTS_TITLE("혜택 내역"),
    DISCOUNT_AMOUNT_TITLE("총혜택 금액"),
    DISCOUNTED_PRICE_TITLE("할인 후 예상 결제 금액"),
    BADGE_TITLE("12월 이벤트 배지"),

    /*
    출력값 포맷
     */
    TITLE_FORMAT("<%s>"),
    ORDER_FORMAT("%s %d개%n"),
    DISCOUNT_FORMAT("%s: %s원%n"),
    MONEY_FORMAT("%s원"),
    BADGE_FORMAT("%s"),
    MONEY_DECIMAL_FORMAT("###,###"),
    NONE("없음");



    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getIntroductionMessageWithMonth() {
        return String.format(message, PromotionConfig.MONTH.getNumber());
    }

    public String getIntroductionMessageWithMonthAndDay(int day) {
        return String.format(message, PromotionConfig.MONTH.getNumber(), day);
    }

    public String getOrderMessage(OrderResponse eachMenu) {
        return String.format(ORDER_FORMAT.message, eachMenu.getName(), eachMenu.getQuantity());
    }

    public String getGiftMessage(GiftMenuResponse eachMenu) {
        return String.format(ORDER_FORMAT.message, eachMenu.getName(), eachMenu.getQuantity());
    }

    public String getDiscountMessage(AvailableDiscountResponse discount) {
        if (discount.getDiscountAmount() == 0) {
            return String.format(DISCOUNT_FORMAT.message, discount.getName(), formatMoney(discount.getDiscountAmount()));
        }
        return String.format(DISCOUNT_FORMAT.message, discount.getName(), "-" + formatMoney(discount.getDiscountAmount()));
    }

    public String getMoneyMessage(int money) {
        return String.format(MONEY_FORMAT.message, formatMoney(money));
    }

    public String getDiscountMoneyMessage(int money) {
        if (money == 0) {
            return String.format(MONEY_FORMAT.message, formatMoney(money));
        }
        return String.format(MONEY_FORMAT.message, "-" + formatMoney(money));
    }


    public String getBadgeMessage(String badgeName) {
        return String.format(BADGE_FORMAT.message, badgeName);
    }

    public String getTitleMessage() {
        return String.format(TITLE_FORMAT.message, message);
    }

    private String formatMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_DECIMAL_FORMAT.message);
        return decimalFormat.format(money);
    }

    public String getMessage() {
        return message;
    }
}
