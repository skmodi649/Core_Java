import java.util.Arrays;

public class Opengenus_Arrays_Demo {
    public static void main(String[] args){
        int[] arr = {8, 4, 7, 9, 3, 10, 5};
        Arrays.sort(arr);
        System.out.println("Sorted Array: ");
        for(int i = 0 ; i < 7 ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
