import java.util.Scanner;

public class ParityCheck {
    String dataR = new String();
    String dataS = new String();
    int i , choice , len;
    int count1 , count2;
    public void DataSender(){
        Scanner sc = new Scanner(System.in);
        System.out.println("------------At Sender------------");
        System.out.println("Enter the Binary data : ");
        dataS = sc.next();
        len = dataS.length();
        int ones = 0;
        for(int i = 0 ; i < len ; i++){
            char ch = dataS.charAt(i);
            if(ch != '1' && ch != '0'){
                System.out.println("Enter binary values");
                return;
            }
            else if(ch == 1){
                ones++;
            }
            else{
                ones+=0;
            }
        }
        if(ones % 2 == 0){
            System.out.println("Perform the even parity");
            even();
        }
        else{
            System.out.println("Perform the odd parity");
            odd();
        }
    }
}
