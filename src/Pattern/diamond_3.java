package Pattern;

import java.util.Scanner;

public class diamond_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= (n-i); j++){
                System.out.print(" ");
            }
            int limit = 2*i - 1;
            for(int k = 1;k <= limit; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n-1; i >= 1; i--){
            for(int j = 0; j <= (n-i); j++){
                System.out.print(" ");
            }
            int limit = 2*i - 1;
            for(int k = 1;k <= limit; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
