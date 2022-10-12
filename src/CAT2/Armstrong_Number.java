
// Sum of cube of digits of number is equal to the original number
package CAT2;

import java.util.Scanner;
public class Armstrong_Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int original = n, sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += Math.pow(d, 3);
            n = n / 10;
        }
        if(sum == original)
            System.out.println("Armstrong Number!");
        else
            System.out.println("Not Armstrong Number!");
    }
}
