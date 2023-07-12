# **part2 객체 지향 프로그래밍**

## chapter06 클래스

객체 지향 프로그램의 특징 → **캡슐화, 상속, 다형성**

**캡슐화 : 객체의 데이터(필드), 동작(메소드)을 하나로 묶고 실제 구현 내용을 외부에 감추는 것**

- 외부의 잘못된 사용으로 인해 객체가 손상되지 않게 해줌

**상속 : 부모객체가 자신이 가지고 있는 필드와 메소드를 자식객체에게 물려주어 자식객체가 사용 할 수 있도록 하는것**

- 코드의 재사용성을 높여줌
- 유지 보수 시간을 최소화 시켜줌

**다형성 : 사용방법은 동일하지만 실행 결과가 다양하게 나오는 성질**

instance member : 객체에 소속된 멤버 (객체를 생성해야만 사용할 수 있는 멤버)

static member : 클래스에 고정된 멤버 (객체 없이도 사용할 수 있는 멤버)

생성자와 메소드의 매개변수명이 인스턴스 멤버인 필드명과 동일한 경우, 인스턴스 필드임을 강조하고자 할 때 **this**를 주로 사용

정적 메소드와 정적 블록은 객체가 없어도 실행된다는 특징 때문에 내부에 인스턴스 필드나 인스턴스 메소드를 사용 할 수 없다.

또한 객체 자신의 참조인 this도 사용할 수 없다.

final 필드에 초기값을 줄 수 있는 두가지 방법

- 필드 선언 시에 초기값 대입
- 생성자에서 초기값 대입

상수 선언

```java
static final 타입 상수 //상수 이름은 모두 대문자로 작성하는 것이 관례
```

싱글톤 패턴

어플리케이션 전체에서 단 한개의 객체만 생성해서 사용하고 싶다면 싱글톤 패턴을 적용 할 수 있음

싱글톤패턴의 핵심은 생성자를 private 접근 제한해서 외부에서 new 연산자로 생성자를 호출할 수 없도록 막는 것.

---

확인문제

1-3 O

2-4 O 

3-4 O

4-3 O 

5-2 X

6-4 O

7-2 O

8-2 O 

9-4  X 

10-4 O

11-3 O

12- 필드 ,  생성자, 메소드 O

13- O

```java
public class Ex13 {
    
    String name;
    String id;
    String password;
    int age;
    
}
```

14- O

```java
public class Ex14 {
    String name;
    String id;
    String password;
    int age;

    public Ex14(String name, String id){
        this.name = name;
        this.id = id;
    }
}
```

15- O

```java
public class Ex15 {
    String name;
    String id;
    String password;
    int age;

    public Ex15(String name, String id){
        this.name = name;
        this.id = id;
    }
    public boolean login (String id, String password){
        boolean result;
        if (id.equals("hong") && password.equals("12345")){
            result = true;
        }
        else{ 
            result = false;
        }
        return result;
    }
    
    public void logout(){
        System.out.println(id + "님이 로그아웃 되었습니다.");
    }
}
```

16- O

```java
public class Ex16 {
    public void println(int value){
        System.out.println(value);
    }
    public void println(boolean value){
        System.out.println(value);
    }
    public void println(double value){
        System.out.println(value);
    }
    public void println(String value){
        System.out.println(value);
    }
}
```

17- O

```java
public class Ex17 {
    public static void println(int value){
        System.out.println(value);
    }
    public static void println(boolean value){
        System.out.println(value);
    }
    public static void println(double value){
        System.out.println(value);
    }
    public static void println(String value){
        System.out.println(value);
    }
}
```

18- O

```java
public class Ex18 {
    private static Ex18 ex18 = new Ex18();
    private Ex18(){
    }
    public Ex18 getInstance(){
        return ex18;
    }
}
```

19- O

```java
public class Ex19 {
    public static final int MAX_BALANCE = 1000000;
    public static final int MIN_BALANCE = 0;

    private int balance;

    public void setBalance(int balance) {
        if(MIN_BALANCE <= balance && balance <= MAX_BALANCE){
            this.balance = balance;
        }
    }

    public int getBalance() {
        return balance;
    }
}
```

20- O

```java
// Account.java

public class Account {
    String accountNumber;
    String name;
    int balance;
    public Account(String accountNumber, String name, int balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }

}
```

```java
// BankApplication.java

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean run = true;

        while(run){
            System.out.println("--------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("선택> ");
            String strNum = scanner.nextLine();

            switch (strNum){
                case "1" -> {
                    System.out.println("--------");
                    System.out.println("계좌생성");
                    System.out.println("--------");
                    System.out.printf("계좌번호: ");
                    String accountNumber = scanner.nextLine();
                    System.out.printf("계좌주: ");
                    String name = scanner.nextLine();
                    System.out.printf("초기입금액: ");
                    int balance = Integer.parseInt(scanner.nextLine());
                    Account newAccount = new Account(accountNumber, name, balance);
                    for(int i =0; i< accountArray.length ; i++){
                        if(accountArray[i] == null){
                            accountArray[i] = newAccount;
                            break;
                        }
                    }
                    System.out.println("결과: 계좌가 생성되었습니다.");
                }
                case "2" -> {
                    System.out.println("--------");
                    System.out.println("계좌목록");
                    System.out.println("--------");
                    for(int i =0; i< accountArray.length ; i++){
                        if(accountArray[i] != null){
                            System.out.println(
                                    accountArray[i].getAccountNumber()
                            + "  " + accountArray[i].getName()
                            + "  " + accountArray[i].getBalance()
                            );
                        }
                    }
                }
                case "3" -> {
                    System.out.println("--------");
                    System.out.println("예금");
                    System.out.println("--------");
                    System.out.print("계좌번호: " );
                    Account account = findAccount(scanner.nextLine());
                    System.out.print("예금액: ");
                    int balance = Integer.parseInt(scanner.nextLine());
                    account.setBalance(account.getBalance() + balance);
                }
                case "4" -> {
                    System.out.println("--------");
                    System.out.println("출금");
                    System.out.println("--------");
                    System.out.print("계좌번호: " );
                    Account account = findAccount(scanner.nextLine());
                    System.out.print("출금액: ");
                    int balance = Integer.parseInt(scanner.nextLine());
                    account.setBalance(account.getBalance() - balance);
                }
                case "5" -> {
                    System.out.println("프로그램 종료");
                    run = false;
                }
            }
        }
    }
    public static Account findAccount(String accountNumber){
        Account account = null;
        for(int i = 0; i < accountArray.length ; i++) {
            if(accountArray[i] != null){
                if (accountArray[i].getAccountNumber().equals(accountNumber)){
                    account = accountArray[i];
                    break;
                }
            }
        }
        return account;
    }
}
```
