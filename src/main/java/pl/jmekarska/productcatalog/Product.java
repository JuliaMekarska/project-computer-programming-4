package pl.jmekarska.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String description;
    private String image;
    private boolean isOnline;
    private BigDecimal price;
    private final String color;
    private final String type;
    private final String size;


    public Product(UUID uuid, String name, String desc, String color, String type, String size) {
        this.uuid = uuid.toString();
        this.name = name;
        this.description = desc;
        this.image = null;
        this.isOnline = false;
        this.price = null;
        this.color = color;
        this.type = type;
        this.size = size;
    }

    public String getId() {
        return uuid;
    }

    public void setPrice(BigDecimal price){
        this.price=price;
    }

    public void setImage(String image){
        this.image=image;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void changePrice(BigDecimal newPrice) {

        price = newPrice;
    }

    public String getImage(){
        return this.image;
    }

    public void setIsOnline(boolean online){
        this.isOnline=online;
    }
    public boolean getIsOnline(){
        return this.isOnline;
    }

    public void setIsPublished(Boolean isPublished){
        if (this.image == null || this.price == null){
            throw new ProductCantBePublishedException();
        }
        this.isOnline = isPublished;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}