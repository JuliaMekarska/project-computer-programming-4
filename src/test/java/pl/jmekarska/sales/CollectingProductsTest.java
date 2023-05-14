package pl.jmekarska.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    @BeforeEach
    void setUp(){
        cartStorage = new CartStorage();
        productDetailsProvider = new ProductDetailsProvider();
    }

    @Test
    void itAllowsToCollectProductsToCart(){
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customerId = thereIsCustomer("AMI");

        //Act
        sales.addToCart(customerId,productId);

        //Assert
        assertThereIsXProductsInCustomersCart(customerId,1);
    }

    private void assertThereIsXProductsInCustomersCart(String customerId, int productsCount) {
        Cart customersCart = cartStorage.load(customerId).get();
        assert customersCart.itemsCount() == productsCount;
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private Sales thereIsSalesModule() {
        return new Sales(cartStorage,productDetailsProvider);
    }
}
