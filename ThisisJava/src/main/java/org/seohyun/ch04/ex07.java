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