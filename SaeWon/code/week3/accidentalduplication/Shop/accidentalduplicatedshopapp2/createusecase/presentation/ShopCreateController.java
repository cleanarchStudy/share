package accidentalduplicatedshopapp2.createusecase.presentation;

import accidentalduplicatedshopapp2.createusecase.application.ShopCreateCommand;
import accidentalduplicatedshopapp2.createusecase.application.ShopCreateService;

@Controller
@RequestMapping("/shops")
public class ShopCreateController {

    private final ShopCreateService service;

    @Autowired
    public ShopCreateController(ShopCreateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> createShop(@RequestBody ShopCreateRequest shop){
        ShopCreateCommand command = ShopCreateCommand.from(shop);
        Long response = service.register(command);
        return new ResponseEntity<>(response, HttpStatus.CREATE);
    }

}
