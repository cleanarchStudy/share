package accidentalduplicatedshopapp.domain;

import accidentalduplicatedshopapp.application.ShopCommand;
import accidentalduplicatedshopapp.domain.Shop;

import java.util.Map;
import java.util.Optional;

public interface ShopRepository{

    Shop save(ShopCommand shop);

    Optional<Shop> findById(String shopId);


}
