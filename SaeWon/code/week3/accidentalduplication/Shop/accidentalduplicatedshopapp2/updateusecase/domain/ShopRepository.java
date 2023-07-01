package accidentalduplicatedshopapp2.updateusecase.domain;

import accidentalduplicatedshopapp2.updateusecase.domain.Shop;

import java.util.Optional;

public interface ShopRepository {

    Optional<Shop> findById(String shopId);
}
