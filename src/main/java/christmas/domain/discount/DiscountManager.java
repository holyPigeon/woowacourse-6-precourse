package christmas.domain.discount;

import christmas.domain.discount.discounts.DdayDiscount;
import christmas.domain.discount.discounts.GiftDiscount;
import christmas.domain.discount.discounts.SpecialDiscount;
import christmas.domain.discount.discounts.WeekdayDiscount;
import christmas.domain.discount.discounts.WeekendDiscount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;

import java.util.ArrayList;
import java.util.List;

public class DiscountManager {

    private List<Discount> discounts;

    private DiscountManager(Order order, Day day) {
        this.discounts = List.of(
                DdayDiscount.of(order, day),
                WeekdayDiscount.of(order, day),
                WeekendDiscount.of(order, day),
                SpecialDiscount.of(order, day),
                GiftDiscount.of(order, day)
        );
    }

    public static DiscountManager create(Order order, Day day) {
        return new DiscountManager(order, day);
    }

    public List<Discount> getDiscounts() {
        return new ArrayList<>(discounts);
    }
}
