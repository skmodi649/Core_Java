import java.util.Scanner;

public class crc_check {
    static Scanner scan = new Scanner(System.in);

    public static String sender() {
        // Step 1 : Receive the data and the divisor

        System.out.println("Enter the data : ");
        String data = scan.next();
        System.out.println("Enter the divisor : ");
        String div = scan.next();
        int append = div.length() - 1;
        String new_data = data;

        // Step 2 : Append n - 1 zeros at the end of the data, where n is the length of the divisor string

        while (append > 0) {
            new_data = new_data + "0";
            append--;
        }

        /* Step 3 : Let's perform the binary divison, remove the leading zeros from the dividend and the divisor because
                    they do not affect the divison */
        // Note : We are considering the input bits to be at most 64bit

        long dividend = Long.parseLong(new_data);
        long divisor = Long.parseLong(div);

        long quotient = dividend / divisor;
        long crc_remainder = dividend % divisor;

        // Now append the remainder to the data replacing the zeros

        String crc = String.valueOf(crc_remainder);
        data = data + crc;

        return data;
    }

    public void receiver(String data){

        String crc_data = sender();
        if(data.equals(crc_data))
            System.out.println("Message received successfully!");
        else
            System.out.println("Code error!");
    }
    public static void main(String[] args) {
        System.out.println("NAME : SURAJ KUMAR");
        System.out.println("REGISTRATION NUMBER : 20BCE2835");
        System.out.println("---------------------------------------------------");
        crc_check obj = new crc_check();
        System.out.println("Enter the data to be received :");
        int val = scan.nextInt();
        String data = "";
        while(val > 0){
            int d = val % 2;
            if(d == 0)
                data = data + '0';
            else
                data = data + '1';
            val = val / 2;
        }
        System.out.println("Binary equivalent : " + data);
        obj.receiver(data);
    }
}
