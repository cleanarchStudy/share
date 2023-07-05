package adapter.in.web;


import application.port.in.ShowCurrencyQuery;
import application.port.in.ShowCurrencyUseCase;
import application.port.out.ShowCurrencyResponse;

public class CurrencyController {

    private final ShowCurrencyUseCase useCase;

    public CurrencyController(ShowCurrencyUseCase useCase) {
        this.useCase = useCase;
    }

    public ShowCurrencyResponse show(String memberId){
        ShowCurrencyQuery query = new ShowCurrencyQuery(memberId);
        return useCase.show(query);
    }
}



