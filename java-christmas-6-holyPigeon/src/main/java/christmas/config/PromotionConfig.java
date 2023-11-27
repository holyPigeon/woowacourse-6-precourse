package christmas.config;

public enum PromotionConfig {

    YEAR(2023),
    MONTH(12),
    MINIMUM_DAY(1),
    MAXIMUM_DAY(31),
    TOTAL_QUANTITY_MAXIMUM(20),
    EACH_QUANTITY_MINIMUM(1),
    ;

    private final int number;

    PromotionConfig(int number) {
        this.number = number;
    }

    public static boolean isDayInRange(Integer day) {
        return day >= MINIMUM_DAY.number  || day <= MAXIMUM_DAY.number;
    }

    public static boolean isTotalQuantityGreaterThanCondition(int totalQuantity) {
        return totalQuantity > TOTAL_QUANTITY_MAXIMUM.number;
    }

    public static boolean isEachQuantityValid(int eachQuantity) {
        return eachQuantity < EACH_QUANTITY_MINIMUM.number;
    }

    public int getNumber() {
        return number;
    }
}
