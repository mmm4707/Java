package ch12.stringBuilderExample;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF")
                .insert(0, "ABC")
                .delete(3, 4)
                .toString();   //메소드 체이닝 패턴
        System.out.println(data);
    }
}
