package FAT;

import java.util.*;

public class First {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Converting string to char array
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        String sortedString = new String(tempArray);
        for(int i = 0; i < sortedString.length() - 1; i++){
            char ch1 = sortedString.charAt(i);
            char ch2 = sortedString.charAt(i+1);
            if(ch1 == ch2){
                System.out.print(ch1);
                break;
            }
        }
    }
}
