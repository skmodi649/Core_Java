import java.io.PrintWriter;
import java.util.Scanner;

public class RecFibonacci {
    public static int fib(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fib(n-2)+fib(n-1);

    }
    public static void IterateFib(int n){
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for(int i = 3 ; i <= n; i++){
            int c = a + b;
            System.out.print(c+" ");
            a = b;
            b = c;


        }
    }
    public static void main(String[] asdfasdf){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
       // System.out.println(fib(n));
        IterateFib(n);
    }
}
