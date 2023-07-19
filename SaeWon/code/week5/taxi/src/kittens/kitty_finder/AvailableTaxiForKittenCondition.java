package kittens.kitty_finder;


import taxi.taxi_finder.AvailableTaxiCondition;

public class AvailableTaxiForKittenCondition extends AvailableTaxiCondition {
    // 사용자에게 특정 거리만큼 가깝고 손님을 태우지 않은경우 등등 기본조건은 부모클래스에 존재
    // 아래사항 확장
    // 1. supplier는 고양이서비스를 지원해야한다.
    // 2. 운전자의 고양이 알러지가 없어야한다.
}
