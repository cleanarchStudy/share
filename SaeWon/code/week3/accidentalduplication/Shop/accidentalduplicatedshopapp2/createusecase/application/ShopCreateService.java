package accidentalduplicatedshopapp2.createusecase.application;

import accidentalduplicatedshopapp.domain.Shop;
import accidentalduplicatedshopapp.domain.ShopRepository;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
@Service
@Transactional
public class ShopCreateService {

    private final ShopRepository repository;

    @Autowired
    public ShopCreateService(ShopRepository repository) {
        this.repository = repository;
    }

    public Long register(ShopCreateCommand command) {
        Shop shop = command.toEntity();
        Shop registeredShop = repository.save(shop);
        return registeredShop.getId();
    }


}
