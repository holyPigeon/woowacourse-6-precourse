package christmas.dto.response;

import christmas.domain.PromotionService;

import java.util.List;

public class DiscountPreviewResponse {

    private final int day;
    private final List<OrderResponse> orderResponse;
    private final int initialPrice;
    private final List<GiftMenuResponse> giftMenuResponses;
    private final List<AvailableDiscountResponse> availableDiscountResponses;
    private final int discountAmount;
    private final int discountedPrice;
    private final String badge;

    public DiscountPreviewResponse(PromotionService promotionService) {
        this.day = promotionService.getDay().getPrimitiveDay();
        this.orderResponse = promotionService.findOrderResponse();
        this.initialPrice = promotionService.calculateInitialPrice();
        this.giftMenuResponses = promotionService.findGiftMenuResponses();
        this.availableDiscountResponses = promotionService.findAvailableDiscountResponses();
        this.discountAmount = promotionService.calculateDiscountAmount();
        this.discountedPrice = promotionService.calculateDiscountedPrice();
        this.badge = promotionService.calculateBadge().getName();
    }

    public static DiscountPreviewResponse from(PromotionService promotionService) {
        return new DiscountPreviewResponse(promotionService);
    }

    public int getDay() {
        return day;
    }

    public List<OrderResponse> getOrderResponses() {
        return orderResponse;
    }

    public int getInitialPrice() {
        return initialPrice;
    }

    public List<GiftMenuResponse> getGiftMenuResponses() {
        return giftMenuResponses;
    }

    public List<AvailableDiscountResponse> getAvailableDiscountResponses() {
        return availableDiscountResponses;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public String getBadge() {
        return badge;
    }
}
