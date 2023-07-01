package accidentalduplicatedshopapp2.readusecase.presentation;

import accidentalduplicatedshopapp2.readusecase.domain.Shop;

public record ShopReadResponse(
        String shopName,
        String address,
        String description
){
 public static ShopReadResponse from(Shop shop){
     return new ShopReadResponse(
             shop.getShopName(),
             shop.getAddress(),
             shop.getDescription()
     );
 }
}
