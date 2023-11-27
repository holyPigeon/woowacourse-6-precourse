package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.Day;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.menu.Quantity;

import java.util.Map;

public class GiftDiscount implements Discount {

    private final String name = "증정 이벤트";
    private int discountAmount = 0;
    private boolean isAvailable = false;

    private GiftDiscount(Order order, Day day) {
        checkIsAvailableDiscount(order, day);
        calculateDiscountAmount(order, day);
    }

    public static GiftDiscount of(Order order, Day day) {
        return new GiftDiscount(order, day);
    }

    @Override
    public void calculateDiscountAmount(Order order, Day day) {
        if (isAvailable) {
            discountAmount = Menu.getGiftMenus()
                    .entrySet()
                    .stream()
                    .mapToInt(entry -> getMenuPrice(entry) * getEachQuantity(entry))
                    .sum();
        }
    }

    private static boolean isMenuTypeDessert(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getType()
                .equals(MenuType.DESSERT);
    }

    private static Integer getQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    @Override
    public void checkIsAvailableDiscount(Order order, Day day) {
        isAvailable = order.calculateInitialPrice() >= 120000;
    }

    private static Integer getEachQuantity(Map.Entry<Menu, Quantity> entry) {
        return entry.getValue().getPrimitiveQuantity();
    }

    private static int getMenuPrice(Map.Entry<Menu, Quantity> entry) {
        return entry.getKey().getPrice();
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
}
