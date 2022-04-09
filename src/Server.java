import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public Server(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for the client to arrive.............");
            socket = server.accept();
            System.out.println("Client accepted!");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while(!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch(IOException e){
                    System.out.println(e);
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        System.out.println("Name : Suraj Kumar");
        System.out.println("Registration Number : 20BCE2835");
        System.out.println("------------------------------------------------------------------");
        Server server = new Server(5000);
    }
}
