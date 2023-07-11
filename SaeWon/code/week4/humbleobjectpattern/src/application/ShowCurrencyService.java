package application;

import application.port.in.ShowCurrencyQuery;
import application.port.in.ShowCurrencyUseCase;
import application.port.out.ShowCurrencyDBGateway;
import application.port.out.ShowCurrencyResponse;
import application.port.out.ShowCurrencyResponseMapper;
import domain.Currency;

import java.math.BigDecimal;

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

/**
 * ShowCurrencyService를 테스트하기 쉬운 이유는 dbGateway를 구현한 ShowCurrencyJpaPersistenceAdapter가 험블객체인데 이를 직접 호출하지 않고,
 * dbGateway라는 out bound port를 참조하도록 하고 험블객체를 밖으로 밀어냈기 때문에 테스트가 쉬워짐*/
class ShowCurrencyServiceTest {

    public static void main(String[] args) {
        // given
        // 1. ShowCurrencyDbGateway를 테스트용으로 모킹하여 구현 MockDbPersistenceAdapter 사용
        ShowCurrencyService sut = new ShowCurrencyService(
                                     new MockShowCurrencyPersistenceAdapter(),
                                     new MockShowCurrencyResponseMapper()
                                     );
        ShowCurrencyQuery query = new ShowCurrencyQuery("testId1");

        // when
        ShowCurrencyResponse result = sut.show(query);

        // then
        System.out.println("result = " + result.amount());
        String expectedValue = "1000000 원";
        System.out.println("expectedValue = " + expectedValue);
        System.out.printf("pass : %b", result.amount().equals(expectedValue));
    }

    static class MockShowCurrencyPersistenceAdapter implements ShowCurrencyDBGateway{
        @Override
        public Currency LoadByShowCurrencyQuery(ShowCurrencyQuery query) {
            return switch (query.currencyId()) {
                case "testId1" -> new Currency("testId1", BigDecimal.valueOf(1_000_000L));
                case "testId2" -> new Currency("testId2", BigDecimal.valueOf(2_000_000L));
                case "testId3" -> new Currency("testId3", BigDecimal.valueOf(3_000_000L));
                default -> null;
            };
        }
    }

    static class MockShowCurrencyResponseMapper implements ShowCurrencyResponseMapper{
        @Override
        public ShowCurrencyResponse convert(Currency currency) {
            return new ShowCurrencyResponse(currency.getAmount() + " 원");
        }
    }
}
