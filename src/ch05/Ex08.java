package ch05;

public class Ex08 {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int sum = 0;
        int total = 0;
        double avg = 0;

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