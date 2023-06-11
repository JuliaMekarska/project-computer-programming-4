package pl.jmekarska.payu;

public class Product {
    private String name;
    private Integer unitPrice;
    private Integer quantity;
    /*
    {
                "name": "Nice tshirt",
                "unitPrice": "150",
                "quantity": "1"
            },
     */

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Product setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}