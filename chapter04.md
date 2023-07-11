# **part1 자바 언어 기초**

## chapter04 조건문과 반복문

Java 12이후부터는 switch문에서 Expressions(표현식)을 사용할수있다.

 break문을 없애는 대신에 화살표와 중괄호를 사용해 가독성이 좋아졌다.

```java
public class SwitchExpressonsExample {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade) {
            case 'A', 'a' -> System.out.println("우수 회원 입니다.");
            case 'B', 'b' -> System.out.println("일반 회원 입니다.");
            default -> System.out.println("손님입니다.");
        }
    }
}
```

SwitchExpressions을 사용하면 스위치 된 값을 변수에 바로 대입할수도 있다. 단일값일 경우에는 화살표 오른쪽에 값을기술하면되고, 중괄호를 사용할 경우에는 yield(Java13부터 사용가능)
키워드로 값을 지정하면 된다. 단, 이 경우에는 default가 반드시 존재해야 한다.

중첩된 반복문에서 바깥쪽 반복문까지 종료시키려면 바깥쪽반복문에 이름(레이블)을 붙이고, break: 이름' 을 사용하면 된다.

![스크린샷 2023-07-09 오전 5 29 15](https://github.com/mmm4707/Java/assets/39482751/0a367e0c-43dd-4b3f-a7e6-5ca7177dd91c)

---

확인문제

1-2 O

2- X

```java
case “A” → score1 = 100;
case “B” → yield result = 100 -20;
default → score1 = 60;
```

3-O

```java
public class ex03 {
    public static void main(String[] args) {
        int result = 0;
        for(int i=1 ; i <= 100 ; i++){
            if(i%3 == 0){
                result += i;
            }
        }
        System.out.println(result);
    }
}
```

4-O

```java
public class ex04 {
    public static void main(String[] args) {

        while (true) {
            int random1 = (int)(Math.random()*6)+1;
            int random2 = (int)(Math.random()*6)+1;

            System.out.println("(" + random1 + "," + random2 + ")");
            if(random1+random2==5){
                break;
            }
        }
    }
}
```

5-O

```java
public class ex05 {
    public static void main(String[] args) {

        for(int x = 1 ; x<=10 ; x++){
            for(int y = 1 ; y<=10; y++){
                int a = 4*x + 5*y;
                if(a==60) System.out.println(x+","+y);
            }
        }
    }
}
```

6-O

```java
public class ex06 {
    public static void main(String[] args) {
        for (int i = 1; i<6 ; i++){
            for (int j = 0 ; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

7-O

```java
import java.util.Scanner;
public class ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int balance = 0;

        while(run){
            System.out.println("-----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------");
            System.out.print("선택> ");
            String strNum = scanner.nextLine();

            switch (strNum){
                case "1" -> {
                    System.out.print("예금액> ");
                    balance += Integer.parseInt(scanner.nextLine());
                }
                case "2" -> {
                    System.out.print("출금액> ");
                    balance -= Integer.parseInt(scanner.nextLine());
                }
                case "3" -> {
                    System.out.println("잔고> " + balance);
                }
                case "4" -> {
                    System.out.println("프로그램 종료");
                    run = false;
                }
            }
        }
    }
}
```
