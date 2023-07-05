package application.port.in;

import application.port.out.ShowCurrencyResponse;

public interface ShowCurrencyUseCase {
    ShowCurrencyResponse show(ShowCurrencyQuery query);
}
