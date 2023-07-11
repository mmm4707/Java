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