# **part2 객체 지향 프로그래밍**

## chapter08 인터페이스

인터페이스에 선언된 필드는 모두 public static final 특성을 갖기 때문에 public static final을 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.

---

**인터페이스 정적 메소드 선언** 

```java
package ch08.staticMethod;

public class Audio implements RemoteControl{
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume>RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume<RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨: " + volume);
    }

    private int memoryVolume;

    @Override
    public void setMute(boolean mute) {
        if(mute){
            this.memoryVolume = this.volume;
            System.out.println("무음 처리합니다.");
            setVolume(RemoteControl.MIN_VOLUME);
        } else {
            System.out.println("무음 해제합니다.");
            setVolume(this.memoryVolume);
        }
    }
}
```

```java
package ch08.staticMethod;

public class Television implements RemoteControl{
    private int volume;
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume>RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume<RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV 볼륨: " + volume);
    }

}
```

```java
package ch08.staticMethod;

public interface RemoteControl {
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    void turnOn();
    void turnOff();
    void setVolume(int volume);

    default void setMute(boolean mute){

    }
    static void changeBattery(){
        System.out.println("리모콘 건전지를 교환합니다.");
    }
}
```

```java
package ch08.staticMethod;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        System.out.println();

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        System.out.println();

        RemoteControl.changeBattery();
    }
}
```

---

**인터페이스 상속**

```java
package ch08.interfaceInheritance;

public interface InterfaceA {
    //추상 메소드
    void methodA();
}

package ch08.interfaceInheritance;

public interface InterfaceB {
    //추상 메소드
    void methodB();
}

package ch08.interfaceInheritance;

public interface InterfaceC extends InterfaceA,InterfaceB{
    //추상 메소드
    void methodC();
}
```

```java
package ch08.interfaceInheritance;

public class InterfaceCImpl implements InterfaceC{

    @Override
    public void methodA() {
        System.out.println("InterfaceCImpl-methodA() 실행");
    }

    @Override
    public void methodB() {
        System.out.println("InterfaceCImpl-methodB() 실행");
    }

    @Override
    public void methodC() {
        System.out.println("InterfaceCImpl-methodC() 실행");
    }
}
```

```java
package ch08.interfaceInheritance;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
```

---

**인터페이스 객체 타입 확인**

```java
//Java 11 까지
public void method(Vehicle vehicle){
	if(vehicle instanceof Bus){
	Bus bus = (Bus) vehicle;
	//bus 변수 사용
	}
}
```

```java
//Java 12 부터
if(vehicle instanceof Bus bus){
 //bus 변수 사용
}
```

---

**봉인된 인터페이스**

Java15 부터 무분별한 자식 인터페이스 생성을 방지하기 위해서 봉인된 인터페이스를 사용할 수 있다.

```java
public sealed interface InterfaceA permits InterfaceB {...}
```

sealed 키워드를 사용하면 permits 키워드 뒤에 상속가능한 자식인터페이스를 지정해야 한다.

봉인된 InterfaceA를 상속하는 InterfaceB는 non-sealed 키워드로 다음과 같이 선언하거나 sealed 키워드를사용해서 또 다른 봉인 인터페이스로 선언해야 한다.

```java
public non-sealed interface InterfaceB extends InterfaceA{...}
```

---

확인문제

1-1 O

2-3 O

3-3 X

4-1,2,3,4 O

5- O

```java
package ch08.Ex05;

public interface Remocon {
    public void powerOn();
}
```

```java
package ch08.Ex05;

public class TV implements Remocon{

    @Override
    public void powerOn() {
        System.out.println("TV를 켰습니다.");
    }

    public static void main(String[] args) {
        Remocon r = new TV();
        r.powerOn();
    }
}
```

6- O

```java
package ch08.Ex06;

public class Cat implements Soundable{
    @Override
    public String sound() {
        return "야옹";
    }
}
```

```java
package ch08.Ex06;

public class Dog implements Soundable{
    @Override
    public String sound() {
        return "멍멍";
    }
}
```

```java
package ch08.Ex06;

public interface Soundable {
    public String sound();
}
```

```java
package ch08.Ex06;

public class SoundableExample {
    public static void printSound(Soundable soundable){
        System.out.println(soundable.sound());
    }

    public static void main(String[] args) {
        printSound(new Cat());
        printSound(new Dog());
    }
}
```

7- O

```java
package ch08.Ex07;

public class OracleDao implements DataAccessObject{
    @Override
    public void select() {
        System.out.println("Oracle DB에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("Oracle DB에서 삽입");

    }

    @Override
    public void update() {
        System.out.println("Oracle DB에서 수정");

    }

    @Override
    public void delete() {
        System.out.println("Oracle DB에서 삭제");

    }
}
```

```java
package ch08.Ex07;

public class MySqlDao implements DataAccessObject{
    @Override
    public void select() {
        System.out.println("MySql DB에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("MySql DB에서 삽입");
    }

    @Override
    public void update() {
        System.out.println("MySql DB에서 수정");
    }

    @Override
    public void delete() {
        System.out.println("MySql DB에서 삭제");
    }
}
```

```java
package ch08.Ex07;

public interface DataAccessObject {
    public void select();
    public void insert();
    public void update();
    public void delete();

}
```

```java
package ch08.Ex07;

public class DaoExample {
    public static void dbWork(DataAccessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }
}
```

8- O

```java
a instanceof C c
```
