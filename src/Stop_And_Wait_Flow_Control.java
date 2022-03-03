import java.util.Scanner;

public class Stop_And_Wait_Flow_Control {
    static Scanner sc = new Scanner(System.in);
    static int sent, ack, i;

    public void Sender(int frame_size) {
        while (true) {
            for (i = 0; i < frame_size; i++) {
                System.out.println("Frame " + sent + " has been transmitted");
                sent++;
                if (frame_size == sent)
                    break;
            }
            sent = Receiver(frame_size);
            if(sent == -1)
                break;
        }
    }

    public static int Receiver(int frame_size) {
        System.out.println("Enter the last acknowledgement received : ");
        ack = sc.nextInt();
        if (ack >= frame_size)
            return -1;
        else
            sent = ack;
        return sent;
    }

    public static void main(String[] args) {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("-----------------------------------------------------------------");
        Stop_And_Wait_Flow_Control obj = new Stop_And_Wait_Flow_Control();
        int frame_size;
        System.out.println("Enter the frame size : ");
        frame_size = sc.nextInt();
        obj.Sender(frame_size);
    }
}
