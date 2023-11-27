package christmas.domain.order;

public enum Badge {

    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    Badge(String name) {
        this.name = name;
    }

    public static Badge calculateBadge(int price) {
        if (price >= 20000) {
            return Badge.SANTA;
        }
        if (price >= 10000) {
            return Badge.TREE;
        }
        if (price >= 5000) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    public String getName() {
        return name;
    }
}
