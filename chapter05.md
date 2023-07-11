# **part2 객체 지향 프로그래밍**

## chapter05 참조 타입

```java
// 문자열 관련 JAVA 메소드
boolean result  = str1.equals(str2) // 문자열이 같은지 검사(대소문자 구분)
char charValue = subject.charAt(3); // 문자열에서 특정위치의 문자열 추출
int length = subject.length(); // 문자열에서 문자의 개수 얻기
String newStr = oldStr.replace("자바","JAVA"); // 문자열에서 특정문자열을 다른 문자열로 대체
substring(int beg) // 문자열에서 특정 위치의 문자열 잘라내어 가져오기 (beg에서 끝까지 잘라내기)
substring(int beg,end) // 문자열에서 특정 위치의 문자열 잘라내어 가져오기 (beg에서 end앞까지 잘라내기)
int index = subject.indexOf("프로그래밍") // 문자열에서 특정문자열의 위치 찾기(문자열이 없으면 -1 리턴)
boolean result = subject.contains("프로그래밍") // 주어진 문자열이 단순히 포함되어 있는지만 조사
String[] arr = board.split(",") // 문자열이 구분자를 사용하여 여러 개의 문자열로 구성되어 있을 경우, 따로 분리해서 얻기
System.arraycopy(arr1,0,arr2,0,arr1.length) // 배열복사 (원본배열,원본 시작인덱스,새배열,새 시작인덱스,복사항목수)
```
---
확인문제

1-4 O

2-3 O

3-2 O

4-2 O

5-3 O

6- 3, 5 O

7- O

```java
public class ex07 {
    public static void main(String[] args) {
        int[] arrays = { 1, 5, 3, 8, 2 };
        int max = 0;

        for (int i =0; i < arrays.length ; i++) {
            if(max <= arrays[i]){
                max = arrays[i];
            }
        }
        System.out.println(max);
    }
}
```

8-

```java
public class ex08 {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int sum = 0;
        int total = 0;
        double avg = 0.0;

        for(int i = 0; i < array.length; i++){
            total += array[i].length;
            System.out.println("array["+i+"] = "+array[i].length);
            for(int j = 0; j < array[i].length; j++){
                sum += array[i][j];
                System.out.println("array["+i+"]"+"["+j+"] = " + array[i][j]);
                System.out.println("sum = " + sum);
            }
        }
        avg = (double)(sum/total);
        System.out.println("sum: " + sum + "  total: " + total);
        System.out.println("avg = " + avg);
    }
}
```

9- O

```java
import java.util.Scanner;
public class ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int[] scores = null;
        int max = 0;
        int total = 0;
        double avg = 0.0;
        while(run){
            System.out.println("--------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("선택> ");
            String strNum = scanner.nextLine();

            switch (strNum){
                case "1" -> {
                    System.out.print("학생수> ");
                    int student = Integer.parseInt(scanner.nextLine());
                    scores = new int[student];
                }
                case "2" -> {
                    for(int i=0; i< scores.length; i++){
                        System.out.print("scores["+i+"]>");
                        scores[i] = Integer.parseInt(scanner.nextLine());
                    }
                }
                case "3" -> {
                    for(int i=0; i< scores.length; i++){
                        System.out.println("scores["+i+"]>"+ scores[i]);
                    }
                }
                case "4" -> {
                    for(int i=0; i< scores.length; i++){
                        total += scores[i];
                        if(max<=scores[i]){
                            max = scores[i];
                        }
                    }
                    avg = (double) total/scores.length;
                    System.out.println("최고 점수> " + max);
                    System.out.println("평균 점수> " + avg);
                }
                case "5" -> {
                    System.out.println("프로그램 종료");
                    run = false;
                }
            }
        }
    }
}
```
