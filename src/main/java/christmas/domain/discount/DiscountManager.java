package christmas.domain.discount;

import christmas.domain.discount.discounts.DdayDiscount;
import christmas.domain.discount.discounts.GiftDiscount;
import christmas.domain.discount.discounts.SpecialDiscount;
import christmas.domain.discount.discounts.WeekdayDiscount;
import christmas.domain.discount.discounts.WeekendDiscount;

import java.util.ArrayList;
import java.util.List;

public class DiscountManager {

    private List<Discount> discounts;

    private DiscountManager() {
        this.discounts = List.of(
                new DdayDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount(),
                new GiftDiscount()
        );
    }

    public static DiscountManager create() {
        return new DiscountManager();
    }

    public List<Discount> getDiscounts() {
        return new ArrayList<>(discounts);
    }
}
