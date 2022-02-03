import java.util.HashMap;
import java.util.Scanner;

public class OSI_to_ISO {
    static Scanner sc = new Scanner(System.in);
    public static String sender(String message, HashMap<Integer,String> HeaderHash){
        int count = 1;
        StringBuffer sb = new StringBuffer();
        while(count <= 7){
            System.out.println("Enter the header for Layer " + count + " : ");
            String header = sc.next();
            HeaderHash.put(count , header);
            sb.append(header);
            System.out.println("Sender End Message so far : " + sb + message);
            count++;
        }
        sb.append(message);
        return sb.toString();
    }
    public static String receiver(String message, HashMap<Integer , String> HeaderHash){
        int len = message.length();
        int count = 1;
        int i = 0;
        while(count <= 7){
            int header_len = HeaderHash.get(count).length();
            message = message.substring(header_len , len);
            len = len - header_len;
            System.out.println("Receiver End message so far : " + message);
            i = i + header_len;
            count++;
        }
        return message;
    }
    public static void main(String[] args){
        System.out.println("NAME : SURAJ KUMAR");
        System.out.println("REGISTRATION NUMBER : 20BCE2835");
        System.out.println("------------------------------------------------------------");
        System.out.println("Enter the decimal Number : ");
        String originalMessage = "";
        int n = sc.nextInt();
        int val = n;
        // Converting the decimal to binary
        while(val > 0){
            int d = val % 2;
            if(d == 0)
                originalMessage = originalMessage + '0';
            else
                originalMessage = originalMessage + '1';
            val = val / 2;
        }
        HashMap<Integer , String> hash = new HashMap<>();
        String SenderMessage = sender(originalMessage , hash);
        System.out.println("************ Message Sent ***************");
        System.out.println(SenderMessage);
        String ReceiverMessage = receiver(SenderMessage , hash);
        System.out.println("********* Message Received *************");
        System.out.println(ReceiverMessage);
        // Converting the message received back into the decimal
        int receiver_num = 0;
        for(int i = 0 ; i < ReceiverMessage.length() ; i++){
            if(ReceiverMessage.charAt(i) == '1'){
                int pow  = (int)Math.pow(2 , i);
                receiver_num = receiver_num + pow;
            }
        }
        if(n == receiver_num){
            System.out.println("Message received successfully!");
        }
        else{
            System.out.println("Error in the message!");
        }
    }
}
