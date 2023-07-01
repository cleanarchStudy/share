package accidentalduplicatedshopapp2.readusecase.domain;

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
