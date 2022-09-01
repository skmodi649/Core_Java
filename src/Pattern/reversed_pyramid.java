package Pattern;

import java.util.Scanner;

public class reversed_pyramid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i >=1; i--){
            for(int a = 1; a<=(n-i); a++){
                System.out.print(" ");
            }
            for(int j = 1; j<= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
