package pl.jmekarska.productcatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListProductStorage implements ProductStorage{
    List<Product> products;
    public ListProductStorage() {
        this.products = new ArrayList<>();
    }
    @Override
    public List<Product> allProducts() {
        return products;
    }

    @Override
    public void add(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public Product loadById(String productId) {
        return products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .get();
    }

    @Override
    public List<Product> allPublishedProducts() {
        return products
                .stream()
                .filter(Product::getIsOnline)
                .collect(Collectors.toList());

    }
}
