
public class ex07 {
    public static void main(String[] args) {
        int[] arrays = { 1, 5, 3, 8, 2 };
        int max = 0;

        for (int i =0; i < arrays.length ; i++) {
            if(max <= arrays[i]){
                max = arrays[i];
            }
        }
        System.out.println(max);
    }
}