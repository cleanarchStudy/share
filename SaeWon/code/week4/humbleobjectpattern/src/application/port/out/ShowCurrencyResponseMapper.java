package application.port.out;

import domain.Currency;

public interface ShowCurrencyResponseMapper {
    ShowCurrencyResponse convert(Currency currency);
}
