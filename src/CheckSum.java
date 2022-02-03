import java.util.*;

class CheckSum {
    public static void main(String args[]) {
        System.out.println("NAME : SURAJ KUMAR");
        System.out.println("REGISTRATION NUMBER : 20BCE2835");
        System.out.println("----------------------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string input:");
        String input = scan.next();
        int checksum = generateChecksum(input);


        System.out.println("The checksum generated is = "
                + Integer.toHexString(checksum));
        System.out.println("Enter the data to be sent:");
        input = scan.next();
        System.out.println("Enter the checksum to be sent:");
        checksum = Integer.parseInt((scan.next()), 16);

        receive(input, checksum);

    }

    static int generateChecksum(String s) {
        String hex_value = new String();


        int x, i, checksum=0;


        for(i=0 ; i < s.length()-2 ; i=i+2) {
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i+1));
            hex_value = hex_value + Integer.toHexString(x);


            System.out.println(s.charAt(i)+""+s.charAt(i+1) + " : "
                    + hex_value);
            x = Integer.parseInt(hex_value, 16);

            checksum += x;

        }
        if(s.length()%2 == 0) {


            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i+1));
            hex_value = hex_value + Integer.toHexString(x);
            System.out.println(s.charAt(i)+""+s.charAt(i+1) + " : " + hex_value);
            x = Integer.parseInt(hex_value, 16);
        } else {


            x = (int) (s.charAt(i));
            hex_value = "00" + Integer.toHexString(x);
            x = Integer.parseInt(hex_value, 16);
            System.out.println(s.charAt(i) + " : " + hex_value);
        }
        checksum += x;

        hex_value = Integer.toHexString(checksum);


        if(hex_value.length() > 4) {

            int carry = Integer.parseInt((""+hex_value.charAt(0)), 16);

            hex_value = hex_value.substring(1,5);

            checksum = Integer.parseInt(hex_value, 16);

            checksum += carry;

        }
        checksum = generateComplement(checksum);

        return checksum;
    }

    static void receive(String s, int checksum) {
        int generated_checksum = generateChecksum(s);

        generated_checksum = generateComplement(generated_checksum);

        int syndrome = generated_checksum + checksum;

        syndrome = generateComplement(syndrome);


        System.out.println("Syndrome = " + Integer.toHexString(syndrome));
        if(syndrome == 0) {
            System.out.println("Data is received without error.");
        } else {
            System.out.println("There is an error in the received data.");
        }
    }

    static int generateComplement(int checksum) {

        checksum = Integer.parseInt("FFFF", 16) - checksum;
        return checksum;
    }
}