package ch12.mathExample;

public class MathExample {
    public static void main(String[] args) {
        //큰 정수 또는 작은 정수 얻기
        double val1 = Math.ceil(5.3); //올림
        double val2 = Math.floor(5.3); //내림
        System.out.println("val1: " + val1);
        System.out.println("val2: " + val2);

        //큰값 또는 작은값 얻기
        long val3 = Math.max(3, 7); //큰값
        long val4 = Math.min(3, 7); //작은값
        System.out.println("val3: " + val3);
        System.out.println("val4: " + val4);

        //소수 이하 두 자리 얻기
        double val5 = 12.3456; 
        double val6 = val5 * 100;
        long val7 = Math.round(val6); //반올림
        double val8 = val7 / 100.0;
        System.out.println("val8: " + val8);
    }
}
