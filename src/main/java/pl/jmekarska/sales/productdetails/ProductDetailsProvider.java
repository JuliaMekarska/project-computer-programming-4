package pl.jmekarska.sales.productdetails;

import pl.jmekarska.sales.productdetails.ProductDetails;

import java.util.Optional;

public interface ProductDetailsProvider {
    public Optional<ProductDetails> load(String productId);
}