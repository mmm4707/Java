# **part1 자바 언어 기초**

## chapter03 연산자

소형임베디드장치의 C프로그램에서 외부서버의 자바프로그램으로 데이터를 전달한다고가정.

C언어에는 uint8_1 타입이있는데, 이 타입은1byte 크기를 가지면서 0~ 255 값의범위를 가진다.

```java
//비트 논리 곱 연산으로 Unsigned 정수 얻기
int unsignedint = receiveData & 255;
System.out.printIn(unsignedInt
```

```java
 //자바API를 이용해서 Unsigned 정수 얻기
byte receiveData = -120;
int unsignedInt = Byte.toUnsignedInt(receiveData);
```
---

연산자의 연산방향과 우선순위

![스크린샷 2023-07-09 오전 5 29 15](https://github.com/mmm4707/Java/assets/39482751/33c9cb1e-92a4-4b57-bde1-a2d11f783731)

---

확인문제

1-31 O

2-가O

3-pencils/students , pencils%students O

4-value/100 X

5-1,2,3 O

6-true , false O

7- Double.isNan(z) O

오답노트

1. value / 100 * 100
