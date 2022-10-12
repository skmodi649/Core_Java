// Sum of divisors of number except itself is equal to the number

package CAT2;

import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                sum += i;
            }
        }
        if(sum == n)
            System.out.println("Perfect number");
        else
            System.out.println("Not Perfect number");
    }
}
