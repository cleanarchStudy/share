package accidentalduplicatedshopapp2.createusecase.presentation;

import accidentalduplicatedshopapp2.createusecase.application.ShopCreateCommand;
import accidentalduplicatedshopapp2.createusecase.application.ShopCreateService;

public class ShopCreateController {

    private final ShopCreateService service;

    public ShopCreateController(ShopCreateService service) {
        this.service = service;
    }

    public Long createShop(ShopCreateRequest shop){
        ShopCreateCommand command = ShopCreateCommand.from(shop);
        Long response = service.register(command);
        return response;
    }

}
