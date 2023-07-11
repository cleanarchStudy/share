package adapter.out.presentation;

import application.port.out.ShowCurrencyResponse;
import application.port.out.ShowCurrencyResponseMapper;
import domain.Currency;

import java.math.BigDecimal;

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
        return new ShowCurrencyResponse(currency.getAmount() + " 원");
       }
}

/**
 * View Model은 View에서 화면을 검증하는 것이 아니라, Model의 형식이 맞는지만 검증하면 되므로 테스트가 쉬움
 * 여기에서 테스트가 쉽다는 개념은 이 객체를 사용하는 클라이언트코드의 단위테스트가 쉬운 맥락이 아니라 sut 자체의 테스트가 쉬워짐.
 *
 * */
class PresenterTest {
    public static void main(String[] args) {
        // given
        long currencyAmount = 10_000_000L;
        Currency currency = new Currency("any", BigDecimal.valueOf(currencyAmount));
        ShowCurrencyPresenter sut = new ShowCurrencyPresenter();

        // when
        ShowCurrencyResponse result = sut.convert(currency);

        // then
        String expectedValue = currencyAmount + " 원";
        System.out.printf("pass : %b", result.amount().equals(expectedValue));
    }
}

/**
 * View에 대해서는 화면에 대한 책임을 지기 때문에 다양한 요소를 체크해야하며 어려움.
 * (해당 예시는 조회요청에 한정되어있고, 책에서처럼 입력을 받는 상황이라면, 라디오버튼인지, 체크박스인지, 텍스트필드인지 등등도 체크해야함)
 *
 * SpringWebMVC에서 controller단에서 view를 호출하는것 보다 밖에서 해결하도록 뒤로 미루는 이유는 이런 view관련 템플릿엔진이 험블객체이기 때문
 */
class ViewTest {
    public static void main(String[] args) {
        // given
        // 1. 적용될 템플릿 가져오기
        // 2. ShowCurrencyView sut = new ShowCurrencyView();
        // 3. Currency currency = new Currency("any", BigDecimal.valueOf(currencyAmount));
        // 4. ShowCurrencyResponse viewModel = sut.convert(currency);

        // when
        // sut.resolve(viewModel)

        // then
        // 1. 적용될 템플릿이 변환한 html이 실제 브라우저에서 잘 렌더링 되는지
        // 2. 해당 위치에 적절히 데이터가 표시되는지(가려진다거나, 누락된다거나)
        // 3. 렌더링 순서가 달라 깜빡임 등의 증상은 없는지 등등
    }
}