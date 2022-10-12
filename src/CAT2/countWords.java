package CAT2;

import java.util.Scanner;

public class countWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        String str = sc.next();
        String[] arrOfStr = str.split(" ");
        System.out.println("Number of words in the given string: " + arrOfStr.length);
    }
}
