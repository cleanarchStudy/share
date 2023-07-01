package accidentalduplicatedshopapp2.updateusecase.application;

import accidentalduplicatedshopapp2.updateusecase.domain.ShopRepository;
import accidentalduplicatedshopapp2.updateusecase.domain.Shop;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
public class ShopUpdateService {

    private final ShopRepository repository;

    public ShopUpdateService(ShopRepository repository) {
        this.repository = repository;
    }

    //transaction 적용 필요
    public Long update(ShopUpdateCommand command, String shopId) {
        Shop shop = repository.findById(shopId).get();
        Shop newShop = command.toEntity();
        shop.update(newShop);
        return shop.getId();
    }

}
