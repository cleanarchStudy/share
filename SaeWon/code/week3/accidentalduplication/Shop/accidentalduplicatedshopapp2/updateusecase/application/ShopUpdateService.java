package accidentalduplicatedshopapp2.updateusecase.application;

import accidentalduplicatedshopapp.domain.ShopRepository;
import accidentalduplicatedshopapp.domain.Shop;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
@Service
@Transactional
public class ShopUpdateService {

    private final ShopRepository repository;

    @Autowired
    public ShopUpdateService(ShopRepository repository) {
        this.repository = repository;
    }

    public Long update(ShopUpdateCommand command, String shopId) {
        Shop shop = repository.findById(shopId).get();

        Shop newShop = command.toEntity();
        shop.update(newShop);
        return shop.getId();
    }

}
