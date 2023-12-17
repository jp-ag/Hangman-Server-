package pkg;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws Exception {
        this.clientSocket = new Socket(ip, port);
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    public void sendMessage(String msg) throws Exception {
        out.println(msg);
    }

    private String readMessage() throws Exception{
        return this.in.readLine();
    }

    public void stopConnection() throws Exception{
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String args[]) throws Exception{
        Client client = new Client();
        client.startConnection("localhost", 6666);
        Scanner msg = new Scanner(System.in);
        System.out.println("Log: starting connection");
        String inputedString = client.readMessage();
        System.out.println("Server: " + inputedString);
        while (!inputedString.equals("stop")){

		    client.sendMessage(msg.nextLine());
		    
            inputedString = client.readMessage();
            System.out.println("Server: " + inputedString);
	    }   
        msg.close();
        
        client.stopConnection();
    }
}
