package pl.jmekarska.payu;

import java.util.List;

public class OrderCreateRequest {
    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String extOrderId;
    private Integer totalAmount;
    private Buyer buyer;
    private List<Product> products;
    /*
    {
        "notifyUrl": "https://your.eshop.com/notify",
        "customerIp": "127.0.0.1",
        "merchantPosId": "300746",
        "description": "Nice tshirt",
        "currencyCode": "PLN",
        "totalAmount": "110",
        "buyer": {
            "email": "john.doe@example.com",
            "phone": "654111654",
            "firstName": "John",
            "lastName": "Doe",
            "language": "pl"
        },
        "products": [
            {
                "name": Nice tshirt",
                "unitPrice": "50",
                "quantity": "1"
            },
            {
                "name": "Nicer tshirt",
                "unitPrice": "60",
                "quantity": "1"
            }
        ]
    }
     */

    public OrderCreateRequest() {
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public OrderCreateRequest setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        return this;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public OrderCreateRequest setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public OrderCreateRequest setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public OrderCreateRequest setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public OrderCreateRequest setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public OrderCreateRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderCreateRequest setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
