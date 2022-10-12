// A number for which the sum of factorial of its digits is equal to the number

package CAT2;

import java.util.Scanner;

public class Strong_Number {
    public static int factorial(int n){
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }
        return fact;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int N = sc.nextInt();
        int sum = 0, original = N;
        while(N > 0){
            int d = N % 10;
            sum += factorial(d);
            N = N /10;
        }
        if(sum == original)
            System.out.println("Strong number");
        else
            System.out.println("Not Strong number!");
    }
}
