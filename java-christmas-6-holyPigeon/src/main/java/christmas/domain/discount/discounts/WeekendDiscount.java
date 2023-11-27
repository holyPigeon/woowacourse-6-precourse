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

public class WeekendDiscount implements Discount {

    private final String name = "주말 할인";
    private int discountAmount = 0;
    private boolean isAvailable = false;

    private WeekendDiscount(Order order, Day day) {
        checkIsAvailableDiscount(order, day);
        calculateDiscountAmount(order, day);
    }

    public static WeekendDiscount of(Order order, Day day) {
        return new WeekendDiscount(order, day);
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
                .filter(WeekendDiscount::isMenuTypeMain)
                .mapToInt(WeekendDiscount::getQuantity)
                .sum();
    }

    private static boolean isMenuTypeMain(Map.Entry<Menu, Quantity> entry) {
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
        return localDate.getDayOfWeek().getValue() >= 6; // 1: Monday, 2: Tuesday, ..., 7: Sunday
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
