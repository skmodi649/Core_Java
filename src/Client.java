import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address , int port){
        try{
            socket = new Socket(address , port);
            System.out.println("Connection Established!");
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException e){
            System.out.println(e);
        }

        String line = ""; // String to read messages from the input tab
        // The string will be read continuously till you find "Over"
        while(!line.equals("Over")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i){
                System.out.println(i);
            }
        }
        try{
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("------------------------------------------------------------------");
        Client client = new Client("127.0.0.1" , 5000);
    }
}
