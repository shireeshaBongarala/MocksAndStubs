package Warehouse;


public class Order {
    private String product;
    private Integer quantity;
    private boolean filled;

    public Order(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.filled = false;
    }

    public String getProduct() {

        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void fill(Warehouse warehouse) {
        if(warehouse.getInventory(product) >= quantity){
            filled = true;
        }
    }

    public boolean isFilled() {
        return filled;
    }
}
