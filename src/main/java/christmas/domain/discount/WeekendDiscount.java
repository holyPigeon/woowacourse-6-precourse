package christmas.domain.discount;

import christmas.Menu;
import christmas.MenuType;
import christmas.domain.Day;
import christmas.domain.Quantity;
import christmas.util.DateUtil;

import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscount implements Discount{
    @Override
    public int calculateDiscountAmount(Map<Menu, Quantity> customerMenus, Day day) {
        if (isWeekday(day)) {
            return findDiscountableMenuCount(customerMenus) * 2023;
        }
        return 0;
    }

    private static int findDiscountableMenuCount(Map<Menu, Quantity> customerMenus) {
        return (int) customerMenus.keySet()
                .stream()
                .filter(menu -> menu.getType().equals(MenuType.MAIN))
                .count();
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
