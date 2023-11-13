package christmas.domain;

import christmas.domain.discount.DiscountManager;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.Quantity;
import christmas.dto.response.GiftMenuResponse;
import christmas.dto.response.OrderedMenuResponse;

import java.util.List;

public class OrderService {

    private final DiscountManager discountManager;

    private OrderService(Order order, Day day) {
        this.discountManager = DiscountManager.create(order, day);
    }

    public static OrderService create(Order order, Day day) {
        return new OrderService(order, day);
    }

    /*
    주문 메뉴 리스트
     */
    public List<OrderedMenuResponse> findOrderedMenus(Order order) {
        return order.findOrderedMenus();
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
        return List.of(
                GiftMenuResponse.of(Menu.NONE, Quantity.create(1))
        );
    }
}
