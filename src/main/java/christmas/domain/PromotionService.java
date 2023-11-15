package christmas.domain;

import christmas.domain.discount.Discount;
import christmas.domain.discount.DiscountManager;
import christmas.domain.order.Badge;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.dto.response.AvailableDiscountResponse;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderResponse;

import java.util.Collections;
import java.util.List;

public class PromotionService {

    private final DiscountManager discountManager;
    private final Order order;
    private final Day day;

    private PromotionService(Order order, Day day) {
        this.discountManager = DiscountManager.create(order, day);
        this.order = order;
        this.day = day;
    }

    public static PromotionService create(Order order, Day day) {
        return new PromotionService(order, day);
    }

    /*
    주문 메뉴 리스트
     */
    public List<OrderResponse> findOrderResponse() {
        return order.findOrderResponse();
    }

    /*
    할인 전 총주문 금액
     */
    public int calculateInitialPrice() {
        return order.calculateInitialPrice();
    }

    /*
    증정 메뉴 리스트
     */
    public List<GiftMenuResponse> findGiftMenuResponses() {
        if (discountManager.hasGiftDiscount()) {
            return Menu.getGiftMenus()
                    .entrySet()
                    .stream()
                    .map(menuAndQuantity -> GiftMenuResponse.of(menuAndQuantity.getKey(), menuAndQuantity.getValue()))
                    .toList();
        }
        return Collections.emptyList();
    }

    /*
    혜택 내역 리스트
     */
    public List<AvailableDiscountResponse> findAvailableDiscountResponses() {
        return discountManager.findAvailableDiscountResponses();
    }

    /*
    총혜택 금액
     */
    public int calculateDiscountAmount() {
        return discountManager.calculateDiscountAmount();
    }

    /*
    할인 후 예상 결제 금액
     */
    public int calculateDiscountedPrice() {
        return order.calculateInitialPrice() - calculateActualDiscountAmount();
    }

    public int calculateActualDiscountAmount() {
        return discountManager.calculateActualDiscountAmount();
    }

    /*
    배지
     */
    public Badge calculateBadge() {
        return Badge.calculateBadge(calculateDiscountAmount());
    }

    public List<Discount> findAvailableDiscounts() {
        return discountManager.findAvailableDiscounts();
    }

    public Day getDay() {
        return day;
    }
}
