package accidentalduplicatedshopapp2.updateusecase.presentation;

import accidentalduplicatedshopapp2.updateusecase.application.ShopUpdateCommand;
import accidentalduplicatedshopapp2.updateusecase.application.ShopUpdateService;

public class ShopUpdateController {

    private final ShopUpdateService service;

    public ShopUpdateController(ShopUpdateService service) {
        this.service = service;
    }

    public Long updateShop(ShopUpdateRequest shop, String shopIdOnPath){
        ShopUpdateCommand command = ShopUpdateCommand.from(shop);
        Long response = service.update(command, shopIdOnPath);
        return response;
    }

}
