package accidentalduplicatedshopapp.presentation;

import accidentalduplicatedshopapp.application.ShopCommand;
import accidentalduplicatedshopapp.application.ShopService;

public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    // GetMapping(value="/{shopId}")
    public ShopResponse getShop(String shopIdOnPathVariable){
       return service.show(shopIdOnPathVariable);
    }

    // PostMapping
    public Long createShop(ShopCommand shop){
        Long response = service.register(shop);
        return response;
    }

    // PutMapping(value="/{shopId}")
    public Long updateShop(ShopRequest shop, String shopIdOnPath){
        ShopCommand command = ShopCommand.from(shop);
        Long response = service.update(command, shopIdOnPath);
        return response;
    }

}
