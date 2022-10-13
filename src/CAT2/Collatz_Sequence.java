package CAT2;

import java.util.Scanner;

public class Collatz_Sequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps = 0;
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
                System.out.print(n + " ");
                steps++;
            }
            else{
                n = 3*n + 1;
                System.out.print(n + " ");
                steps++;
            }
        }
        System.out.println();
        System.out.println(steps);
    }
}
