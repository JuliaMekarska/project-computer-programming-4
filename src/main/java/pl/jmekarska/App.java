package pl.jmekarska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jkanclerz.productcatalog.HashMapProductStorage;
import pl.jkanclerz.productcatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createNewProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}