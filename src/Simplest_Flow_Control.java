import java.util.Scanner;

public class Simplest_Flow_Control {
    static Scanner sc = new Scanner(System.in);
    static int sent, ack, i;

    public void Sender(int frame_size) {
        for (i = 0; i < frame_size; i++) {
            System.out.println("Frame " + i + " sent");
            sent++;
            Receiver(i);
            if (frame_size == sent)
                break;
        }
    }

    public static void Receiver(int val) {
        System.out.println("Frame "+val+" Received! ");
    }

    public static void main(String[] args) {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("-----------------------------------------------------------------");
        Simplest_Flow_Control obj = new Simplest_Flow_Control();
        int frame_size;
        System.out.println("Enter the frame size : ");
        frame_size = sc.nextInt();
        obj.Sender(frame_size);
    }
}
