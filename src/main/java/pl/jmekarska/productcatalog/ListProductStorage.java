package pl.jmekarska.productcatalog;

import java.util.List;

public class ListProductStorage implements ProductStorage {
    @Override
    public List<Product> allProducts() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
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
                .filter(Product::isOnline)
                .collect(Collectors.tolist());
    }
}