package christmas.domain;

import christmas.domain.discount.Discount;
import christmas.domain.discount.DiscountManager;
import christmas.domain.discount.discounts.GiftDiscount;
import christmas.domain.order.Badge;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderResponse;

import java.util.Collections;
import java.util.List;

public class PreviewService {

    private final DiscountManager discountManager;

    private PreviewService(Order order, Day day) {
        this.discountManager = DiscountManager.create(order, day);
    }

    public static PreviewService create(Order order, Day day) {
        return new PreviewService(order, day);
    }

    /*
    주문 메뉴 리스트
     */
    public List<OrderResponse> findOrderResponse(Order order) {
        return order.findOrderResponse();
    }

    /*
    할인 전 총주문 금액
     */
    public int calculateInitialPrice(Order order) {
        return order.calculateInitialPrice();
    }

    /*
    증정 메뉴 리스트
     */
    public List<GiftMenuResponse> findGiftMenuResponses() {
        if (hasGiftDiscount()) {
            return Menu.getGiftMenus()
                    .entrySet()
                    .stream()
                    .map(entry -> GiftMenuResponse.of(entry.getKey(), entry.getValue()))
                    .toList();
        }
        return Collections.emptyList();
    }

    public boolean hasGiftDiscount() {
        return findAvailableDiscounts()
                .stream()
                .anyMatch(discount -> discount instanceof GiftDiscount);
    }

    /*
    혜택 내역 리스트
     */
    public List<AvailableDiscountResponse> findAvailableDiscountResponses() {
        return findAvailableDiscounts()
                .stream()
                .map(AvailableDiscountResponse::from)
                .toList();
    }

    /*
    총혜택 금액
     */
    public int calculateDiscountAmount() {
        return findAvailableDiscounts()
                .stream()
                .mapToInt(Discount::getDiscountAmount)
                .sum();
    }

    /*
    할인 후 예상 결제 금액
     */
    public int calculateDiscountedPrice(Order order) {
        return order.calculateInitialPrice() - calculateDiscountAmount();
    }

    public List<Discount> findAvailableDiscounts() {
        return discountManager.getDiscounts()
                .stream()
                .filter(Discount::getIsAvailable)
                .toList();
    }

    /*
    배지
     */
    public Badge calculateBadge(Order order) {
        return Badge.calculateBadge(calculateDiscountAmount());
    }
}
