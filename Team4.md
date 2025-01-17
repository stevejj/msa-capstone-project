# 4팀 배달의 민족 - MAS Capston Project

- 분석설계
- SAGA Pattern
- CQRS Pattern
- Correlation / Compensation(Unique Key)
- Request / Response (Feign Client / Sync.Async)
- Gateway
- Deploy / Pipeline
- Circuit Breaker
- Autoscale(HPA)
- Self-Healing(Liveness Probe)
- Zero-Downtime Deploy(Readiness Probe)
- Config Map / Persistence Volume
- Polyglot

---

### 분석설계
- 기능 구현에 집중하기 위해 모델 최소화
- 주문 상세보기를 통해 CQRS 구현

![20220516_224327](https://user-images.githubusercontent.com/25494054/168607817-35bc6c76-4763-4f82-8b68-cddafd15d713.png)

기능 검증 - 주문 요청
![20220516_224327_LI](https://user-images.githubusercontent.com/25494054/168608474-a89cd66c-bb35-47ff-acfa-a038dfb2aa45.jpg)
- 고객이 주문한다.
- 고객이 결제한다.
- 결제가 승인되면 상점으로 주문 요청된다.
- 배달 시작된다.
- 주문 상태가 변경된다.

기능 검증 - 주문 취소
![20220516_224327_LI (2)](https://user-images.githubusercontent.com/25494054/168608490-9e503939-9bd0-49cf-81b8-f5690bffe006.jpg)
- 고객이 주문취소한다.
- 결제 취소된다.
- 상점으로 주문 취소 요청된다.
- 배달 취소된다.
- 주문 상태가 변경된다.

### 실행
```
cd order
mvn spring-boot:run
```

```
cd payment
mvn spring-boot:run
```

```
cd delivery
mvn spring-boot:run
```

```
cd orderDetail
mvn spring-boot:run
```

order : 8082
payment : 8083
delivery : 8081
orderDetail : 8084

```
http localhost:8082/orders
```


