package accidentalduplicatedshopapp.presentation;

import accidentalduplicatedshopapp.application.ShopService;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService service;

    @Autowired
    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping(value="/{shopId}")
    public ResponseEntity<ShopResponse> getShop(@PathVariable("shopId") String shopId){
        ShopResponse response = service.show(shopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createShop(@RequestBody ShopRequest shop){
        Long response = service.register(shop);
        return new ResponseEntity<>(response, HttpStatus.CREATE);
    }

    @PutMapping(value="/{shopId}")
    public ResponseEntity<Long> updateShop(@RequestBody ShopRequest shop, @PathVariable("shopId") String shopId){
        Long response = service.update(shop, shopId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
