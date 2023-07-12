package ch06;

public class Ex19 {
    public static final int MAX_BALANCE = 1000000;
    public static final int MIN_BALANCE = 0;

    private int balance;


    public void setBalance(int balance) {
        if(MIN_BALANCE <= balance && balance <= MAX_BALANCE){
            this.balance = balance;
        }
    }

    public int getBalance() {
        return balance;
    }
}
