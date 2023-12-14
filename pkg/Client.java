package pkg;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws Exception {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage(String msg) throws Exception {
        out.println(msg);
    }

    public void stopConnection() throws Exception{
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String args[]) throws Exception{
        Client client = new Client();
        client.startConnection("localhost", 6666);
        System.out.println("starting connection");
        Scanner msg = new Scanner(System.in);
        client.sendMessage(msg.nextLine());
        msg.close();
        //client.sendMessage("cu");
    }
}