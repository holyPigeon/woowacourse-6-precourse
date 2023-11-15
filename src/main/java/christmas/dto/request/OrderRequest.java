package christmas.dto.request;

public class OrderRequest {

    private String menuName;
    private Integer quantity;

    private OrderRequest(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public static OrderRequest of(String menuName, Integer quantity) {
        return new OrderRequest(menuName, quantity);
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
