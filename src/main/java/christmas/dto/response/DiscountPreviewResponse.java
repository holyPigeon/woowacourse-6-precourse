package christmas.dto.response;

import christmas.domain.PreviewService;
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

    public DiscountPreviewResponse(PreviewService previewService) {
        this.day = day;
        this.orderRespons = previewService.findOrderResponse();
        this.initialPrice = previewService.calculateInitialPrice();
        this.giftMenuResponses = previewService.findGiftMenuResponses();
        this.availableDiscountResponses = previewService.findAvailableDiscountResponses();
        this.discountAmount = previewService.calculateDiscountAmount();
        this.discountedPrice = previewService.calculateDiscountedPrice();
        this.badge = previewService.calculateBadge();
    }

    public static DiscountPreviewResponse from(PreviewService previewService) {
        return new DiscountPreviewResponse(previewService);
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
