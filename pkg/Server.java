package pkg;
import java.net.*;

public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    

    public void start(int port) throws Exception{
        System.out.println("Starting Server on port 6666");
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        System.out.println("Connected");
        GameHandler newGame = new GameHandler(clientSocket);
        newGame.run();
        clientSocket.close();
        System.out.println("connection closed");
    }   

    public static void main(String[] args) throws Exception {
        Server server=new Server();
        server.start(6666);
    }
}