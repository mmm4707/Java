# **part1 자바 언어 기초**

## chapter02 변수와 타입

변수 = 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름

캐멀(camel) 스타일

난타의 등처럼 대소문자가 섞여있도록 작성하는 코드스타일

클래스 명은 대문자로 시작 MemberGrade.java

변수 명은 소문자로 시작 sportsCar

1byte = 8bit, bit는 0과 1이 저장되는 단위

작은단위에서 큰단위로 형변환 가능

큰단위에서 작은단위로 형변환은? 쪼개어서 저장

강제 타입변환 = casting

---

확인문제

1-4 O

2-2,3,4,6,7 X

3- O

|  | 1byte | 2byte | 4byte | 8byte |
| --- | --- | --- | --- | --- |
| 정수타입 | byte | short, char | int | long |
| 실수타입 |  |  | float | double |
| 논리타입 | boolean |  |  |  |

4- int,double  -  age,price - 10,3.14 O

5-3 O

6-3 X

7-3 O

8-3 O

9-1 O

10-2 O

11-13,16 O

오답노트

2- 변수이름으로 $value사용 가능

6-  String strValue = “A”,   char var = (char) strValue;는 컴파일 에러 발생
