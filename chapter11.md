# **part2 객체 지향 프로그래밍**

## chapter11 예외처리

예외란 잘못된 사용 또는 코딩으로 인한 오류를 말한다. 예외가 발생되면 프로그램은 곧바로 종료된다는 점 에서는 에러와 동일하지만, 예외처리를 통해 계속 실행상태를 유지할 수 있다.

- 일반예외(Exception) : 컴파일러가 예외처리 코드여부를 검사하는 예외를 말한다.
- 실행예외(Runtime Exception) : 컴파일러가 예외처리 코드여부를 검사하지 않는 예외를 말한다.

자바는 예외가 발생하면 예외클래스로부터 객체를 생성한다. 이 객체는 예외처리시 사용된다. 자바의 모든에러와 예외클래스는 Throwable을 상속받아 만들어지고, 추가적으로 예외클래스는 java.lang.Exception 클래스를 상속받는다.

<img width="485" alt="스크린샷 2023-07-18 오후 5 05 41" src="https://github.com/mmm4707/Java/assets/39482751/402b27ac-2dd5-4bbc-a13c-b52d98fb18d2">

예외처리코드는 **try-catch-finally** 블록으로 구성

예외발생여부와 상관없이 finally 블록은 항상 실행된다. 심지어 try블록과 catch블록에서 return 문(메소드종료)을 사용하더라도 finally 블록은 항상 실행된다. finally 블록은 옵션으로 생략 가능 하다.

예외 출력 종류

```java
package ch11.exceptionHandlingExample;

public class ExceptionHandlingExample {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        }catch (NullPointerException e){
            System.out.println(e.getMessage()); // 예외가 발생한 이유만 리턴
            //System.out.println(e.toString()); // 예외의 종류도 리턴
            //e.printStackTrace(); // 예외가 어디서 발생했는지 추적한 내용까지도 출력
            //예외 정보를 얻는 3가지 방법
        }finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
```

---

예외 종류에 따른 처리

```java

package ch11.exceptionHandlingExample2;

public class ExceptionHandlingExample2 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i<=array.length; i++){
            try{
                int value = Integer.parseInt(array[i]);
                System.out.println("array["+i+"]: "+value);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }
        }
    }
}
```

**리소스 : 데이터를 제공하는 객체**

리소스는 사용하기 위해 열어야(open) 하며 사용이 끝난 다음에는 닫아야(close)한다.

**try-with-resources 블록**을 사용하면 예외발생여부와 상관없이 리소스를 자동으로 닫아준다.

try-with-resources블록을 사용하기 위해서는 조건이 하나 있다. 

리소스는 java.lang.AutoCloseable 인터페이스를 구현해서AutoCloseable 인터페이스의 close() 메소드를 재정의 해야한다.

Java 8이전버전은 try 괄호안에서 리소스변수를 반드시 선언해야 했지만, Java 9 이후부터는 외부리소스변수를 사용할 수 있다.

---

**리소스 자동 닫기**

```java
package ch11.tryWithResource;

public class MyResource implements AutoCloseable{
    private String name;

    public MyResource(String name){
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1(){
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }
    public String read2(){
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }
    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + name +")닫기]");
    }
}
```

```java
package ch11.tryWithResource;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try(MyResource res = new MyResource("A")){
            String data = res.read1();
            int value = Integer.parseInt(data);
        }catch (Exception e){
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try(MyResource res = new MyResource("A")){
            String data = res.read2();
            //NumberFormatException 발생
            int value = Integer.parseInt(data);
        }catch (Exception e){
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read2();
        } catch (Exception e){
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
```

---

**예외 떠넘기기**

메소드내부에서 예외가 발생할 때 try -catch블록으로 예외를 처리하는 것이 기본이지만, 메소드를 호출한곳으로 예외를 떠넘길수도 있다. 이 때 사용하는 키워드가 throws이다. throws는 메소드선언부 끝에 작성하는데, 떠넘길 예외클래스를 쉼표로 구분해서 나열해주면 된다.

throws 키워드가 붙어있는 메소드에서 해당 예외를 처리하지 않고 떠넘겼기 때문에 이 메소드를 호출하는 곳에서 예외를 받아 처리해야 한다.

**사용자 정의 예외**

통상적으로 일반예외는 Exception의 자식클래스로 선언하고, 실행예외는 RuntimeException의 자식클래스로 선언한다.

```java
package ch11.customException;

public class InsufficientException extends Exception{
    public InsufficientException() {

    }

    public InsufficientException(String message){
        super(message);
    }
}
```

```java
package ch11.customException;

public class Account {
    private long balance;

    public Account(){}

    public long getBalance() {
        return balance;
    }

    public void deposit(int money){
        balance += money;
    }

    public void withdraw(int money) throws InsufficientException{
        if(balance < money){
            throw new InsufficientException("잔고 부족: "+(money-balance)+" 모자람");
        }
        balance -= money;
    }
}
```

```java
package ch11.customException;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();
        //예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        //출금하기
        try{
            account.withdraw(30000);
        } catch (InsufficientException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
```

---

확인문제

1-4 O

2-3 O

3-4 O

4-1 X

5-3 O

6- O

10

숫자로 변환할 수 없음

10

인덱스를 초과했음

10

7- O

```java
package ch11.Ex07;

public class NotExistIDException extends Exception{
    public NotExistIDException() {}
    public NotExistIDException(String message){
        super(message);
    }
}
```

```java
package ch11.Ex07;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {}
    public WrongPasswordException(String message){
        super(message);
    }
}
```

```java
package ch11.Ex07;

public class LoginExample {
    public static void main(String[] args) {
        try{
            login("white", "12345");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            login("blue", "54321");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
        if(!id.equals("blue")) {
            throw new NotExistIDException("아이디가 존재하지 않습니다.");
        }
        if(!password.equals("12345")){
            throw new WrongPasswordException("패스워드가 틀립니다.");
        }
    }
}
```

8- O

```java
package ch11.Ex08;

import java.io.IOException;

public class FileWriter implements AutoCloseable{
    public FileWriter(String filePath) throws IOException {
        System.out.println(filePath + " 파일을 엽니다.");
    }

    public void write(String data) throws IOException{
        System.out.println(data + "를 파일에 저장합니다.");
    }
    @Override
    public void close() throws Exception {
        System.out.println("파일을 닫습니다.");
    }
}
```

```java
package ch11.Ex08;

public class FileWriterExample {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("file.txt")){
            fw.write("Java");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
```
