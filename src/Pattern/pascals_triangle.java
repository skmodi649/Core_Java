package Pattern;

import java.util.Scanner;

public class pascals_triangle {
    public static int factorial(int n){
        if(n == 0)
            return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j<= (n-i); j++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                int value = factorial(i)/(factorial(i-j)*factorial(j));
                System.out.print(" "+value);
            }
            System.out.println();
        }
    }
}
