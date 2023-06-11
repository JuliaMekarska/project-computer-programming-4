package pl.jmekarska.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PayUTest {
    @Test
    void creatingNewOrder() {
        PayU payu = thereIsPayU();
        OrderCreateRequest request = thereIsExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(request);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest thereIsExampleOrderCreateRequest() {
        OrderCreateRequest request = new OrderCreateRequest();
        request
                .setNotifyUrl("https://your.eshop.com/notify")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("Nice tshirts")
                .setCurrencyCode("PLN")
                .setTotalAmount(60)
                .setBuyer(new Buyer()
                        .setEmail("john.doe@example.com")
                        .setPhone("654111654")
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Nicer tshirt")
                                .setUnitPrice(60)
                                .setQuantity(1)
                ));
//        {
//            "notifyUrl": "https://your.eshop.com/notify",
//                "customerIp": "127.0.0.1",
//                "merchantPosId": "145227",
//                "description": "Nice tshirts",
//                "currencyCode": "PLN",
//                "totalAmount": "50",
//                "extOrderId":"9zzhe7f2wzcosusti1h9nt",
//                "buyer": {
        //            "email": "john.doe@example.com",
        //                    "phone": "654111654",
        //                    "firstName": "John",
        //                    "lastName": "Doe",
        //                    "language": "en"
        //        },
        //            "products": [
        //            {
        //                "name": "Cute tshirt",
        //                    "unitPrice": "50",
        //                    "quantity": "1"
        //            }
//   ]
//        }
        return request;
    }

    private PayU thereIsPayU() {
        return new PayU(PayUApiCredentials.sandbox(), new RestTemplate());
    }
}