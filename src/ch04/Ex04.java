package ch04;

public class Ex04 {
    public static void main(String[] args) {

        while (true) {
            int random1 = (int)(Math.random()*6)+1;
            int random2 = (int)(Math.random()*6)+1;

            System.out.println("(" + random1 + "," + random2 + ")");
            if(random1+random2==5){
                break;
            }
        }
    }
}