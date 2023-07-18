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
