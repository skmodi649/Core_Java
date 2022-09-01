package Pattern;

import java.util.Scanner;

public class left_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) // outer loop for number of rows
        {
            for (int j = 1; j <= (n - i); j++) { // inner loop for spaces
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
