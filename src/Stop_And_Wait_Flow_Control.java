import java.util.Scanner;

public class Stop_And_Wait_Flow_Control {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int frame_size , sent = 0 , ack , i;
        System.out.println("Enter the number of frames : ");
        frame_size = sc.nextInt();
        while(true){
            for(i = 0 ; i < frame_size ; i++){
                System.out.println("Frame " + sent + " has been transmitted");
                sent++;
                if(frame_size == sent)
                    break;
            }
            System.out.println("Enter the last acknowledgement received : ");
            ack = sc.nextInt();
            if(ack >= frame_size)
                break;
            else
                sent = ack;
        }
    }
}
