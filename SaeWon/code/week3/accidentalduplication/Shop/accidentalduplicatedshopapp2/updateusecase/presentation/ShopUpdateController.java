package accidentalduplicatedshopapp2.updateusecase.presentation;

import accidentalduplicatedshopapp2.updateusecase.application.ShopUpdateCommand;
import accidentalduplicatedshopapp2.updateusecase.application.ShopUpdateService;

@Controller
@RequestMapping("/shops")
public class ShopUpdateController {

    private final ShopUpdateService service;

    @Autowired
    public ShopUpdateController(ShopUpdateService service) {
        this.service = service;
    }

    @PutMapping(value="/{shopId}")
    public ResponseEntity<Long> updateShop(@RequestBody ShopUpdateRequest shop, @PathVariable("shopId") String shopId){
        ShopUpdateCommand command = ShopUpdateCommand.from(shop);
        Long response = service.update(command, shopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
