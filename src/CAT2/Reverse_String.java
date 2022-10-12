package CAT2;

import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuffer buffer = new StringBuffer(str);
        StringBuffer reverse = buffer.reverse();
        String reverseString = reverse.toString();
        System.out.println(reverseString);
    }
}
