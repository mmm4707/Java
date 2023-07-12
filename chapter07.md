# **part2 객체 지향 프로그래밍**

## chapter07 상속

다른언어와 달리 자바는 다중 상속을 허용하지 않는다. 즉, 여러 개의 부모 클래스를 상속할 수 없다. 따라서 extends 뒤에는 단 하나의 부모 클래스만이 와야 한다.

**Rules for Java Method Overriding**

- 부모 메소드의 선언부(리턴 타입, 메소드 이름, 매개변수)와 동일해야 한다.
- 접근 제한을 더 강하게 오버라이딩할 수 없다(public → private 으로 변경 불가)
- 새로운 예외를 throws할 수 없다.

**final**

- 클래스를 선언할 때 final 키워드를 class 앞에 줕이면 최종적인 클래스이므로 더 이상 상속할 수  없는 클래스가 된다.
    - 즉 final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.
- 메소드를 선언할 때 final 키워드를 붙이면 이 메소드는 최종적인 메소드이므로 오버라이딩할 수 없는 메소드가 된다.
    - 즉 부모 클래스를 상속해서 자식 클래스를 선언할 때, 부모클래스에 선언된 final 메소드는 자식 클래스에서 재정의 할 수 없다.

부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.

비록 변수는 자식 객체를 참조하지만 변수로 접근 가능한 멤버는 부모 클래스 멤버로 한정된다.

그러나 자식 클래스에서 오버라이딩된 메소드가 있다면 부모 메소드 대신 오버라이딩된 메소드가 호출된다. 이것은 **다형성**과 관련있다.

자식타입은 부모타입으로 자동 변환되지만, 반대로 부모 타입은 자식타입으로 자동 변환되지 않는다.

대신 캐스팅연산자로 강제 타입 변환 할 수 있다.

```java
Parent parent = new Child(); // 자동 타입 변환
Child child = (Child) parent; // 강제 타입 변환
```

**다형성**

사용방법은 동일하지만 실행 결과가 다양하게 나오는 성질.

자동타입변환 + 메소드 오버라이딩 → 다형성

**객체 타입확인**

매개변수의 다형성에서 실제로 어떤 객체가 매개값으로 제공되었는지 확인하는 방법이 있다.

꼭 매개변수가 아니더라도 변수가 참조하는 객체의 타입을 확인하고자 할 때, instanceof 연산자를 사용 할 수 있다.

```java
boolean result = 객체 instanceof 타입;
```

```java
// Child 타입으로 강제 타입 변환하기 전에 매개값이 Child타입인지 여부를 instanceof 연산자로 확인
public void method(Parent parent){
	if(parent instanceof Child){
		Child child = (Child) parent;
		//child 변수 사용
	}
}

// Java 12부터는 instanceof 연산의 결과가 true일 경우, 우측 타입변수를 사용할 수 있기 때문에 강제 타입 변환이 펼요없음
if(parent instanceof Child child){
	//child 변수 사용
}
```

**추상클래스**

클래스들의 공통적인 필드나 메소드를 추출해서 선언한 클래스

추상클래스는 새로운 실체 클래스를 만들기 위한 부모 클래스로만 사용됨. 즉, 추상클래스는 extends 뒤에만 올 수 있음

```java
public abstract class 클래스명 {
	//필드
	//생성자
	//메소드
}
```

추상메소드는 자식 클래스의 공통 메소드라는 것만 정의할 뿐, 실행 내용을 가지지 않는다.

반드시 자식 클래스에서 재정의(오버라이딩)해서 실행 내용을 채워야 한다.

**봉인된 클래스**

Java 15 부터 무분별한 자식 클래스 생성을 방지하기 위해 봉인된(sealed) 클래스가 도입되었다.

다음과 같이 Person의 자식 클래스는 Employee와 Manager만 가능하고, 그 이외는 자식 클래스가 될 수 없도록 Person을 봉인된 클래스로 선언할 수 있다.

```java
public sealed class Person permits Employee, Manager { ... }
// sealed로 봉인하고 permits뒤에 상속가능한 자식클래스 지정
public final class Employee extends Person { ... }
// 더 이상 상속할 수 없음 , 자식클래스 못 만듦
public non-sealed class Manager extends Person { ... }
// 봉인 해제 , 자식클래스 만들 수 있음
```

---

확인문제

1-1 O

2-2 O

3-1 O

4-4 O

5-2 O

6- O

Parent클래스에 기본생성자가 없어서 Child 클래스 생성자 안에 [t](http://this.name)his.name부분을 지우고 super(name)을 붙여줘야 함.

7-  O 

Parent(String nation) call

Parent() call

Child(String name) call

Child() call

8-O

스노우 타이어가 굴러갑니다.

스노우 타이어가 굴러갑니다.

9- 2 O

10- O

추상메소드를 오버라이딩 하지 않아서

11- O

super

12- O

a instanceof C c
