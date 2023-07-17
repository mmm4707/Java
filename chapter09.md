# **part2 객체 지향 프로그래밍**

## chapter09 중첩 선언과 익명 객체

클래스가 여러 클래스와 관계를 맺는 경우에는 독립적으로 선언하는것이 좋으나, 특정클래스만 관계를 맺을경우에는 중첩클래스로 선언하는 것이 유지보수에 도움이되는 경우가 많다.

중첩클래스란 클래스내부에 선언한 클래스를 말하는데, 증첩클래스를 사용하면 클래스의 멤버를 쉽게 사용할 수 있고 외부에는 중첩관계클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다는 장점이 있다.

Java 17부터 정적필드와 정적메소드 선언이 가능하다.

```java
package ch09.InstanceMemberClass;

public class A {
    //인스턴스 멤버 클래스
    class B {
        //인스턴스 필드
        int field1 = 1;

        //정적 필드(Java 17부터 허용)
        static int field2 = 2;

        //생성자
        B() {
            System.out.println("B-method1 실행");
        }

        //인스턴스 메소드
        void method1() {
            System.out.println("B-method1 실행");
        }

        //정적 메소드(Java 17부터 허용)
        static void method2() {
            System.out.println("B-method2 실행");
        }
    }

    //인스턴스 메소드
    void useB() {
        B b = new B();
        System.out.println(b.field1);
        b.method1();

        //B 클래스의 정적 필드 및 메소드 사용
        System.out.println(B.field2);
        B.method2();
    }
}
```

```java
package ch09.InstanceMemberClass;

public class AExample {
    public static void main(String[] args) {
        // A 객체 생성
        A a = new A();

        // A 인스턴스 메소드 호출
        a.useB();
    }
}
```

---

로컬변수(생성자 또는 메소드의 매개변수 또는 내부에서 선언된 변수)를 로컬클래스에서 사용할 경우 로컬변수는 final 특성을 갖게 되므로 값을 읽을 수 만 있고 수정할 수 없게 된다. 이것은 로컬 클래스 내부에서 값을 변경하지 못하도록 제한하기 때문이다.

Java 8 이후부터는 명시적으로 final 키워드를 붙이지 않아도 되지만 Java7 이전에는 final키워드를 붙여줘야 했다.

---

확인문제

1-4 O

2-3 O

3-3 O

4- O

```java
package ch09.InstanceMemberClass.Ex04;

public class Car {
    class Tire {}
    static class Engine {}
}
```

```java
package ch09.InstanceMemberClass.Ex04;

public class CarExample {
    public static void main(String[] args) {
        Car mycar = new Car();
        Car.Tire tire = mycar.new Tire();
        Car.Engine engine = new Car.Engine();
    }
}
```

5- O

```java
package ch09.Ex05;

public interface Action {
    public void work();
}
```

```java
package ch09.Ex05;

public class ActionExample {
    public static void main(String[] args) {
        Action action = new Action() {
            @Override
            public void work() {
                System.out.println("복사를 합니다.");
            }
        };
        action.work();
    }
}
```

6- O

```java
package ch09.Ex06;

public interface Vehicle {
    public void run();

}
```

```java
package ch09.Ex06;

public class Anonymous {
    Vehicle field = new Vehicle() {
        @Override
        public void run() {
            System.out.println("자전거가 달립니다.");
        }
    };
    void method1(){
        Vehicle localVar = new Vehicle() {
            @Override
            public void run() {
                System.out.println("승용차가 달립니다.");
            }
        };
        localVar.run();
    }
    void method2(Vehicle v){
        v.run();
    }
}
```

```java
package ch09.Ex06;

public class AnonymouseExample {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        anony.field.run();
        anony.method1();
        anony.method2(
                new Vehicle() {
                    @Override
                    public void run() {
                        System.out.println("트럭이 달립니다.");
                    }
                }
        );
    }
}
```

7- O

nickName은 final이기 때문에 startChat()메소드에서 값을 변경할 수 없음
