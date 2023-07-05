package adapter.out.presentation;

import application.port.out.ShowCurrencyResponse;
import application.port.out.ShowCurrencyResponseMapper;
import domain.Currency;

/**
 * 224p 프레젠터와 뷰
 * 화면의 위치를 보여주어야 하는 뷰와 다르게, 보여주기 위한 뷰 모델만 검증하기 때문에 테스트가 쉬움.
 * 아래의 경우 단위를 표시해주는 뷰모델로 뒤에 " 원"이 붙는지만 확인하면 테스트가 끝남.
 * 따라서 Humble Object가 아님!
 *
 * ShowCurrencyPresenter(adapter) -> ShowCurrencyResponseMapper(port) <- ShowCurrencyService(application)
 * */
public class ShowCurrencyPresenter implements ShowCurrencyResponseMapper {
    @Override
    public ShowCurrencyResponse convert(Currency currency) {
        return new ShowCurrencyResponse(currency + " 원");
    }
}
