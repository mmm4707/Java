package ch06.Ex20;

public class Account {
    String accountNumber;
    String name;
    int balance;
    public Account(String accountNumber, String name, int balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }


}
