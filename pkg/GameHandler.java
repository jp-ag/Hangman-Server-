package pkg;

import java.net.*;
import java.io.*;

public class GameHandler {

    public Socket connectionSocket;
    public HangmanInterface game;

    public GameHandler(Socket socket, HangmanInterface g){
        this.connectionSocket = socket;
        this.game = g;
    }
    
    
    public void run() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream()));
        PrintWriter output = new PrintWriter(this.connectionSocket.getOutputStream());
        
        while(!game.isFinished()){
            output.println("Input a letter");
            String inputedString = input.readLine();
            System.out.println(inputedString);
            break;
            // checks if input is letter and of length one
            //while (inputedString.length() > 1 && Character.isLetter(inputedString.charAt(0))){
            //    output.println("Please input only one letter");
            //    inputedString = input.readLine();
            //}

            //output.println(game.guessLetter(inputedString));
        
    }

    }
    
}
