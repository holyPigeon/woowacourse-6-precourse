package christmas.domain.discount;

import christmas.domain.discount.discounts.DdayDiscount;
import christmas.domain.discount.discounts.GiftDiscount;
import christmas.domain.discount.discounts.SpecialDiscount;
import christmas.domain.discount.discounts.WeekdayDiscount;
import christmas.domain.discount.discounts.WeekendDiscount;
import christmas.domain.order.Day;
import christmas.domain.order.Order;
import christmas.dto.response.AvailableDiscountResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiscountManager {

    private final List<Discount> discounts;

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

    public int calculateDiscountAmount() {
        return findAvailableDiscounts()
                .stream()
                .mapToInt(Discount::getDiscountAmount)
                .sum();
    }

    public int calculateActualDiscountAmount() {
        return findAvailableDiscounts()
                .stream()
                .filter(discount -> !(discount instanceof  GiftDiscount))
                .mapToInt(Discount::getDiscountAmount)
                .sum();
    }

    public boolean hasGiftDiscount() {
        return findAvailableDiscounts()
                .stream()
                .anyMatch(discount -> discount instanceof GiftDiscount);
    }

    public List<AvailableDiscountResponse> findAvailableDiscountResponses() {
        return findAvailableDiscounts()
                .stream()
                .map(AvailableDiscountResponse::from)
                .toList();
    }

    private List<Discount> findAvailableDiscounts() {
        return discounts
                .stream()
                .filter(Discount::getIsAvailable)
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountManager that = (DiscountManager) o;
        return Objects.equals(getDiscounts(), that.getDiscounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscounts());
    }

    public List<Discount> getDiscounts() {
        return new ArrayList<>(discounts);
    }
}
