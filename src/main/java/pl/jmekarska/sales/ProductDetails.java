package pl.jmekarska.sales;

import java.math.BigDecimal;

public class ProductDetails {
    String productId;
    String name;
    BigDecimal price;
    int quantity;



    public ProductDetails(String productId, String name, BigDecimal price) {
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity+=1;
    }
}
