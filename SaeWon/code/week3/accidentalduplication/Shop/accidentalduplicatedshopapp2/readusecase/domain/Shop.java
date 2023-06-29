package accidentalduplicatedshopapp2.readusecase.domain;

public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;
    private String shopName;
    private String address;
    @Lob
    private String description;

    @Builder
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
