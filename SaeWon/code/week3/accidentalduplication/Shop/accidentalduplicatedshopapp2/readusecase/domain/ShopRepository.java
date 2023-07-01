package accidentalduplicatedshopapp2.readusecase.domain;

import accidentalduplicatedshopapp2.readusecase.domain.Shop;

import java.util.Optional;

public interface ShopRepository{

    Optional<Shop> findById(String shopId);
}
