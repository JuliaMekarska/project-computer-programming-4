package pl.jmekarska;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pl.jmekarska.payu.PayU;
import pl.jmekarska.payu.PayUApiCredentials;
import pl.jmekarska.productcatalog.HashMapProductStorage;
import pl.jmekarska.productcatalog.ProductCatalog;
import pl.jmekarska.sales.Sales;
import pl.jmekarska.sales.cart.CartStorage;
import pl.jmekarska.sales.offering.OfferCalculator;
import pl.jmekarska.sales.payment.PaymentGateway;
import pl.jmekarska.sales.payment.PayuPaymentGateway;
import pl.jmekarska.sales.productdetails.InMemoryProductDetailsProvider;
import pl.jmekarska.sales.productdetails.ProductCatalogProductDetailsProvider;
import pl.jmekarska.sales.productdetails.ProductDetailsProvider;
import pl.jmekarska.sales.reservation.InMemoryReservationStorage;
import pl.jmekarska.web.SessionCurrentCustomerContext;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String product1=productCatalog.addProduct("T-shirt","Cute t-shirt","pink","\"U\" neck","S");
        productCatalog.changeImageById(product1,"/images/tshirt1.png");
        productCatalog.changePriceById(product1, BigDecimal.valueOf(21.21));
        productCatalog.publishProduct(product1);

        String product2=productCatalog.addProduct("T-shirt","Cool t-shirt","red","\"V\" neck","M");
        productCatalog.changeImageById(product2,"/images/tshirt2.png");
        productCatalog.changePriceById(product2, BigDecimal.valueOf(22.22));
        productCatalog.publishProduct(product2);

        String product3=productCatalog.addProduct("T-shirt","Nice t-shirt","yellow","\"U\" neck","L");
        productCatalog.changeImageById(product3,"/images/tshirt3.png");
        productCatalog.changePriceById(product3, BigDecimal.valueOf(23.23));
        productCatalog.publishProduct(product3);


        return productCatalog;
    }

    @Bean
    PaymentGateway createPaymentGateway() {
        return new PayuPaymentGateway(new PayU(PayUApiCredentials.sandbox(), new RestTemplate()));
    }

    @Bean
    Sales createSales(ProductDetailsProvider productDetailsProvider, PaymentGateway paymentGateway) {
        return new Sales(
                new CartStorage(),
                productDetailsProvider,
                new OfferCalculator(productDetailsProvider),
                paymentGateway,
                new InMemoryReservationStorage()
        );
    }

    @Bean
    SessionCurrentCustomerContext currentCustomerContext(HttpSession httpSession) {
        return new SessionCurrentCustomerContext(httpSession);
    }

    @Bean
    ProductDetailsProvider createProductDetailsProvider(ProductCatalog catalog) {
        return new ProductCatalogProductDetailsProvider(catalog);
    }
}