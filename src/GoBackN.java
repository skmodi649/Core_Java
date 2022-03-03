import java.io.*;
public class GoBackN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ack;

    public void Sender() throws IOException {
        System.out.println("Please enter the Window Size: ");
        int window = Integer.parseInt(br.readLine());

        boolean loop = true;
        int sent = 0;

        while (loop) {

            for (int i = 0; i < window; i++) {
                System.out.println("Frame " + sent + " has been transmitted.");
                sent++;
                if (sent == window)
                    break;
            }
            ack = Receiver();
            if (ack == window)
                loop = false;
            else
                sent = ack;
        }
    }

    public static int Receiver() throws IOException {
        System.out.println("Please enter the last Acknowledgement received.");
        int ack = Integer.parseInt(br.readLine());
        return ack;
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("----------------------------------------------------------------");
        GoBackN obj = new GoBackN();
        obj.Sender();
    }
}