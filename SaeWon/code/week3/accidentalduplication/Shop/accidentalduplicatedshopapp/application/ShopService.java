package accidentalduplicatedshopapp.application;

import accidentalduplicatedshopapp.domain.Shop;
import accidentalduplicatedshopapp.domain.ShopRepository;
import accidentalduplicatedshopapp.presentation.ShopResponse;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
@Service
@Transactional
public class ShopService {

    private final ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ShopResponse show(String shopId) {
        return ShopResponse.from(repository.findById(shopId).get());
    }

    public Long register(ShopCommand shop) {
        Shop registeredShop = repository.save(shop);
        return registeredShop.getId();
    }

    public Long update(ShopCommand newShop, String shopId) {
        Shop shop = repository.findById(shopId).get();
        shop.update(newShop);
        return shop.getId();
    }

}
