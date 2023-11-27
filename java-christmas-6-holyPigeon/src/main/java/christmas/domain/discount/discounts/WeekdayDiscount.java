package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.Order;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.Day;
import christmas.domain.order.menu.Quantity;
import christmas.util.DateUtil;

import java.time.LocalDate;
import java.util.Map;

public class WeekdayDiscount implements Discount {

    private final String name = "평일 할인";
    private int discountAmount = 0;
    private boolean isAvailable = false;

    private WeekdayDiscount(Order order, Day day) {
        checkIsAvailableDiscount(order, day);
        calculateDiscountAmount(order, day);
    }

    public static WeekdayDiscount of(Order order, Day day) {
        return new WeekdayDiscount(order, day);
    }

    @Override
    public void calculateDiscountAmount(Order order, Day day) {
        if (isAvailable) {
            discountAmount = findDiscountableMenuCount(order) * 2023;
        }
    }

    private static int findDiscountableMenuCount(Order order) {
        return order.getOrder()
                .entrySet()
                .stream()
                .filter(WeekdayDiscount::isMenuTypeDessert)
                .mapToInt(WeekdayDiscount::getQuantity)
                .sum();
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
        isAvailable = isValidPrice(order) && isWeekday(day);
    }

    private static boolean isValidPrice(Order order) {
        return order.calculateInitialPrice() > 10000;
    }

    private boolean isWeekday(Day day) {
        LocalDate localDate = DateUtil.convertDayToLocalDate(day);
        return localDate.getDayOfWeek().getValue() <= 5; // 1: Monday, 2: Tuesday, ..., 7: Sunday
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
