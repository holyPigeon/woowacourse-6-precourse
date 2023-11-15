package christmas.dto.response;

import christmas.domain.PromotionService;
import christmas.domain.order.Badge;
import christmas.domain.order.Day;

import java.util.List;

public class DiscountPreviewResponse {

    private Day day;
    private List<OrderResponse> orderRespons;
    private int initialPrice;
    private List<GiftMenuResponse> giftMenuResponses;
    private List<AvailableDiscountResponse> availableDiscountResponses;
    private int discountAmount;
    private int discountedPrice;
    private Badge badge;

    public DiscountPreviewResponse(PromotionService promotionService) {
        this.day = day;
        this.orderRespons = promotionService.findOrderResponse();
        this.initialPrice = promotionService.calculateInitialPrice();
        this.giftMenuResponses = promotionService.findGiftMenuResponses();
        this.availableDiscountResponses = promotionService.findAvailableDiscountResponses();
        this.discountAmount = promotionService.calculateDiscountAmount();
        this.discountedPrice = promotionService.calculateDiscountedPrice();
        this.badge = promotionService.calculateBadge();
    }

    public static DiscountPreviewResponse from(PromotionService promotionService) {
        return new DiscountPreviewResponse(promotionService);
    }

    public Day getDay() {
        return day;
    }

    public List<OrderResponse> getOrderResponses() {
        return orderRespons;
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

    public Badge getBadge() {
        return badge;
    }
}
