package accidentalduplicatedshopapp2.readusecase.application;

import accidentalduplicatedshopapp.presentation.ShopResponse;
import accidentalduplicatedshopapp2.readusecase.domain.ShopRepository;

/**
 * 단일 유스케이스로 묶어서 사용하는 예시*/
@Service
@Transactional(readOnly = true)
public class ShopReadService {

    private final ShopRepository repository;

    @Autowired
    public ShopReadService(ShopRepository repository) {
        this.repository = repository;
    }

    public ShopResponse show(String shopId) {
        return ShopResponse.from(repository.findById(shopId).get());
    }
}
