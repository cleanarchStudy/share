# 7장. SRP: 단일 책임 원칙

## 서론

### 오해

- 모듈이 단 하나의 일만 해야한다.

SRP: 하나의 모듈은 오직 하나의 액터에 대해서만 책임져야한다. 

## 징후1: 우발적 중복

서로 다른 액터의 메서드를 갖는경우 서로 다른의미로 사용되던것을 충돌해서 사용가능

서로 다른 액터가 의존하는 코드 너무 가깝게 배치하면 안됨

서로 다른 액터가 의존하는 코드를 서로 분리해야함. 

## 징후2: 병합

서로 다른 팀에 속한 개발자가 서로 상충되는 변경사항을 수정하는 경우 병합 발생

### 해결책

각기 다른 액터별로 데이터만 공유하고 클래스를 이동

단점: 세가지 클래스를 인스턴스화 하고 추적해야함

→ Facade로 해결 

facade

## 결론

메서드와 클래스 수준의 원칙임. 

컴포넌트 차원에서는 공통폐쇄원칙

---

## 액터의 범위 대해서

meeting 생성 

meeting 수락, 수정수락, 거부

meeting 수정, 수정수락, 거부

[https://github.com/f-lab-edu/quick-together/blob/develop/src/main/java/com/flab/quicktogether/meeting/domain/Meeting.java](https://github.com/f-lab-edu/quick-together/blob/develop/src/main/java/com/flab/quicktogether/meeting/domain/Meeting.java)