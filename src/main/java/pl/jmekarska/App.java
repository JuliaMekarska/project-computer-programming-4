package pl.jmekarska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jmekarska.productcatalog.HashMapProductStorage;
import pl.jmekarska.productcatalog.ProductCatalog;
import pl.jmekarska.sales.CartStorage;
import pl.jmekarska.sales.ProductDetailsProvider;
import pl.jmekarska.sales.Sales;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());

        String product1=productCatalog.addProduct("T-shirt","Cute t-shirt","pink","\"U\" neck","S");
        productCatalog.changeImageById(product1,"resources/tshirt1.png");
        productCatalog.changePriceById(product1, BigDecimal.valueOf(21.21));
        productCatalog.publishProduct(product1);

        String product2=productCatalog.addProduct("T-shirt","Cool t-shirt","red","\"V\" neck","M");
        productCatalog.changeImageById(product2,"resources/tshirt2.png");
        productCatalog.changePriceById(product2, BigDecimal.valueOf(22.22));
        productCatalog.publishProduct(product2);

        String product3=productCatalog.addProduct("T-shirt","Nice t-shirt","yellow","\"U\" neck","L");
        productCatalog.changeImageById(product3,"resources/tshirt3.png");
        productCatalog.changePriceById(product3, BigDecimal.valueOf(23.23));
        productCatalog.publishProduct(product3);


        return productCatalog;
    }

    @Bean
    Sales createSales() {
        return new Sales(new CartStorage(), new ProductDetailsProvider());
    }
}