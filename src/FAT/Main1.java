package FAT;
import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean res = false;
        String str = sc.next();
        for(int i = 0; i < str.length(); i++){
            char ch1 = str.charAt(i);
            for(int j = i + 1; j < str.length(); j++){
                char ch2 = str.charAt(j);
                if(ch1 == ch2){
                    System.out.println(ch1);
                    res = true;
                    break;
                }
            }
            if(res){
                break;
            }
        }
    }
}
