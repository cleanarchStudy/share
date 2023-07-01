package accidentalduplicatedshopapp2.readusecase.presentation;

import accidentalduplicatedshopapp2.readusecase.application.ShopReadService;

public class ShopReadController {

    private final ShopReadService service;

    public ShopReadController(ShopReadService service) {
        this.service = service;
    }

    public ShopReadResponse getShop(String shopId){
        ShopReadResponse response = service.show(shopId);
        return response;
    }

}
