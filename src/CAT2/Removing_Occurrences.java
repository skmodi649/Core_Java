package CAT2;

import java.util.Scanner;

public class Removing_Occurrences {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        String str = sc.next();
        System.out.println("Enter the character that you want to remove");
        String ch = sc.next();
        String newString = str.replace(ch, "");
        System.out.println("String after removal: " + newString);
    }
}
