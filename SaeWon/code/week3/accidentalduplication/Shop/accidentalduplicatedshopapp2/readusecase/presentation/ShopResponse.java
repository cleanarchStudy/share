package accidentalduplicatedshopapp2.readusecase.presentation;

import accidentalduplicatedshopapp.domain.Shop;

/**
 * create와 update는 우발적 중복이 발생되는 구간,
 * 기초적인 서비스구성과정에서는 마치 같은 모델이어야 할것처럼 보이므로 둘다 같은 ShopDto를 재사용하고싶어짐.
 *
 * 하지만 추후 서비스가 확장되는 과정에서, 이 DTO 모델이 서로 달라질 여지가 있음.
 * 만약, 가게를 양도하는것으로 이전 주인이 만들어둔 평점을 그대로 물려받고 새로운 사업을 진행하는경우를 막기 위해,
 * 점포이름과, 주소를 수정할 수 없게 된다면, create, update 각 유스케이스에서의 Response모델이 달라짐
 *
 * 따라서, ShopResponse를 Shop*/
public record ShopResponse(
        String shopName,
        String address,
        String description
){
 public static ShopResponse from(Shop shop){
     return new ShopResponse(
             shop.getShopName(),
             shop.getAddress(),
             shop.getDescription()
     );
 }
}
