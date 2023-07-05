package application.port.out;

import application.port.in.ShowCurrencyQuery;
import domain.Currency;
/**
 * 226p 데이터베이스 게이트웨이 구현
 *
 * 애플리케이션에 특화된 업무를 캡슐화함 -> 테스트하기 쉬워짐 (이 객체를 구현한 Test Double을 사용할수있음)
 * 따라서 Humble Object가 아님.
 * */
public interface ShowCurrencyDBGateway {

    Currency LoadByShowCurrencyQuery(ShowCurrencyQuery query);
}
