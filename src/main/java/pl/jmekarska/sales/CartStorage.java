package pl.jmekarska.sales;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CartStorage {
    Map<String, Cart> carts;
    public CartStorage() {
        this.carts = new HashMap<>();
    }
    public Optional<Cart> load(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void save(String customerId, Cart customersCart) {
        carts.put(customerId,customersCart);
    }
}