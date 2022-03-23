import java.util.Scanner;

public class opengenus_octal_to_binary {
    public long toDecimal(long octal){
        // In the following function, we're going to convert a given octal number into its decimal equivalent

        // let's first calculate the number of digits in the given octal number
        int count = 0;
        long n = octal;
        while(n > 0){
            count++;
            n = n / 10;
        }

        // Now convert it into the decimal equivalent
        long decimal = 0;
        for(int i = 0 ; i < count ; i++){
            long d = octal % 10;
            long power = (long)Math.pow(8 , i);
            decimal = decimal + power * d;
            octal = octal / 10;
        }
        return decimal;
    }
     public StringBuffer toBinary(long decimal){
        // In the following method, we're goind to convert a given decimal number into its binary equivalent
        StringBuffer binary = new StringBuffer();
        while(decimal > 0) {
            long d = decimal % 2;
            if (d == 1)
                binary = binary.append('1');
            else
                binary = binary.append('0');
            decimal = decimal / 2;
        }
        return binary.reverse();
     }

     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the octal number : ");
        long octal = sc.nextLong();
        opengenus_octal_to_binary obj = new opengenus_octal_to_binary();
        StringBuffer binary = obj.toBinary(obj.toDecimal(octal));
        System.out.println("Equivalent Binary Number : " + binary);
     }
}
