package christmas.dto.response;

import christmas.domain.discount.Discount;

public class AvailableDiscountResponse {

    private String name;
    private int discountAmount;

    public AvailableDiscountResponse(Discount discount) {
        this.name = discount.getName();
        this.discountAmount = discount.getDiscountAmount();
    }

    public static AvailableDiscountResponse from(Discount discount) {
        return new AvailableDiscountResponse(discount);
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
