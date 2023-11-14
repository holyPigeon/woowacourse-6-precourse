package christmas.dto.request;

public class CustomerMenuRequest {

    private String menuName;
    private Integer quantity;

    private CustomerMenuRequest(String menuName, Integer quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public static CustomerMenuRequest of(String menuName, Integer quantity) {
        return new CustomerMenuRequest(menuName, quantity);
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
