package accidentalduplicatedshopapp2.readusecase.application;

import accidentalduplicatedshopapp2.readusecase.presentation.ShopReadResponse;
import accidentalduplicatedshopapp2.readusecase.domain.ShopRepository;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
// Transactional(readOnly = true)
public class ShopReadService {

    private final ShopRepository repository;

    public ShopReadService(ShopRepository repository) {
        this.repository = repository;
    }

    public ShopReadResponse show(String shopId) {
        return ShopReadResponse.from(repository.findById(shopId).get());
    }
}
