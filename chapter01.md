# **part1 자바 언어 기초**

## chapter01 자바 시작하기

JDK 17 :  java **개발 도구**에 중점

JRE 17  : java **실행 환경**에 중점

JavaSE-17  : java **스펙 내용**에 중점

java Standard Edition 스펙을 준수해서 만든것이 Open JDK, Oracle JDK

---

확인문제 

1-4 O

2-4 X

3-4 O

4-3 O

5-3→2→1→4 X

6-4 O

7-1,2,3,4 O

1. O

```java
public class Example {
public static void main(String[] args) {
System.out.println("개발자가 되기 위한 필수 개발 언어 Java"); }
}
```

오답노트

1. Open JDK와 Oracle JDK를 잘못 설명한 것은 무엇입니까?  2
    
    2. Oracle JDK는 개발 소스공개의무가 없지만 Open JDK는 있다.
    

1. 자바 프로그램 개발과정을 순서대로 적어보세요 3→1→2→4
    
    3. 자바소스파일(~.java)을 작성한다.
    
    1.javac.exe로 바이트코드 파일(~.class)을 생성한다.
    
    2.java.exe로 JVM을 구동시킨다.
    
    4.JVM은 main() 메소드를 찾아 메소드 블록을 실행시킨다.
