package accidentalduplicatedshopapp2.readusecase.presentation;

import accidentalduplicatedshopapp.application.ShopService;
import accidentalduplicatedshopapp.presentation.ShopResponse;
import accidentalduplicatedshopapp2.readusecase.application.ShopReadService;

@Controller
@RequestMapping("/shops")
public class ShopReadController {

    private final ShopReadService service;

    @Autowired
    public ShopReadController(ShopService service) {
        this.service = service;
    }

    @GetMapping(value="/{shopId}")
    public ResponseEntity<ShopResponse> getShop(@PathVariable("shopId") String shopId){
        ShopResponse response = service.show(shopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
