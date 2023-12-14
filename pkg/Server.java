package pkg;
import java.net.*;
import java.io.*;

public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private static final Integer lives = 5;

    public void start(int port) throws Exception{
        System.out.println("Starting Server on port 6666");
        serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        clientSocket = serverSocket.accept();
        HangmanInterface newGame = new HangmanInterface(lives);
        GameHandler gameHandler = new GameHandler(clientSocket, newGame);
        gameHandler.run();
        clientSocket.close();
        System.out.println("connection closed");
    }   

    public static void main(String[] args) throws Exception {
        Server server=new Server();
        server.start(6666);
       
    }
}