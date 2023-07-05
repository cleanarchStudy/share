package application;

import application.port.in.ShowCurrencyQuery;
import application.port.in.ShowCurrencyUseCase;
import application.port.out.ShowCurrencyDBGateway;
import application.port.out.ShowCurrencyResponse;
import application.port.out.ShowCurrencyResponseMapper;
import domain.Currency;

public class ShowCurrencyService implements ShowCurrencyUseCase {

    private final ShowCurrencyDBGateway dbGateway;
    private final ShowCurrencyResponseMapper responseMapper;

    public ShowCurrencyService(ShowCurrencyDBGateway dbGateway, ShowCurrencyResponseMapper responseMapper) {
        this.dbGateway = dbGateway;
        this.responseMapper = responseMapper;
    }

    @Override
    public ShowCurrencyResponse show(ShowCurrencyQuery query) {
        Currency currency = dbGateway.LoadByShowCurrencyQuery(query);
        return responseMapper.convert(currency);
    }
}
