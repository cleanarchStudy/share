package accidentalduplicatedshopapp2.createusecase.application;

import accidentalduplicatedshopapp2.createusecase.domain.Shop;
import accidentalduplicatedshopapp2.createusecase.domain.ShopRepository;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
public class ShopCreateService {

    private final ShopRepository repository;

    public ShopCreateService(ShopRepository repository) {
        this.repository = repository;
    }

    public Long register(ShopCreateCommand command) {
        Shop shop = command.toEntity();
        Shop registeredShop = repository.save(shop);
        return registeredShop.getId();
    }


}
