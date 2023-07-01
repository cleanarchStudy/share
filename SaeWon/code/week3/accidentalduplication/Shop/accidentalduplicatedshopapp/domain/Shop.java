package accidentalduplicatedshopapp.domain;

import accidentalduplicatedshopapp.application.ShopCommand;

// Entity
public class Shop {

    private Long id;
    private String shopName;
    private String address;
    private String description;

    public Shop(String shopName, String address, String description) {
        this.shopName = shopName;
        this.address = address;
        this.description = description;
    }

    public void update(ShopCommand newShop) {
        this.shopName = newShop.shopName();
        this.address = newShop.address();
        this.description = newShop.description();
    }

/*Getter*/
    public Long getId() {
        return id;
    }

    public String getShopName() {
        return shopName;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
