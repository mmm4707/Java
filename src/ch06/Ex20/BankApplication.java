package ch06.Ex20;

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