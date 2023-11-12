package christmas.domain.discount.discounts;

import christmas.domain.discount.Discount;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.Day;
import christmas.domain.order.menu.Quantity;
import christmas.util.DateUtil;

import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscount implements Discount {
    @Override
    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day) {
        if (isWeekday(day)) {
            return findDiscountableMenuCount(customerMenus) * 2023;
        }
        return 0;
    }

    private static int findDiscountableMenuCount(Map<Menu, Quantity> customerMenus) {
        return customerMenus.entrySet().stream()
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
    public boolean isAvailableDiscount(Map<Menu, Quantity> customerMenus, Day day) {
        return isWeekday(day);
    }

    private boolean isWeekday(Day day) {
        LocalDate localDate = DateUtil.convertDayToLocalDate(day);
        return localDate.getDayOfWeek().getValue() >= 6; // 1: Monday, 2: Tuesday, ..., 7: Sunday
    }
}
