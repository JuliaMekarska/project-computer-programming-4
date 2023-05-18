package pl.jmekarska.sales;
import pl.jmekarska.productcatalog.Product;
import java.util.Optional;

import pl.jmekarska.productcatalog.HashMapProductStorage;
import pl.jmekarska.productcatalog.Product;
import pl.jmekarska.productcatalog.ProductCatalog;
import pl.jmekarska.productcatalog.ProductStorage;

import java.util.List;
import java.util.Optional;
public class ProductDetailsProvider {
    public Optional<ProductDetails> loadCartForProduct(String productId) {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        ProductDetails productDetails = new ProductDetails(productCatalog.loadById(productId).getId(), productCatalog.loadById(productId).getName(), productCatalog.loadById(productId).getPrice());
        return Optional.of(productDetails);

    }
}
