package pkg;

import java.net.*;
import java.io.*;

public class GameHandler {

    private Socket connectionSocket;
    private Integer lives = 5;

    public GameHandler(Socket socket){
        this.connectionSocket = socket;
    }
    
    
    public void run() throws Exception {
        HangmanInterface game = new HangmanInterface(lives);
        BufferedReader input = new BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream()));
        PrintWriter output = new PrintWriter(this.connectionSocket.getOutputStream(), true);
        
        System.out.println("Starting game");
        while(!game.isFinished()){
            output.println(game.printStatus() + " " + game.printLives()+ " Input a letter");
            String inputedString = input.readLine();
            System.out.println(inputedString);
            // checks if input is not letter and of length one
            while (inputedString.length() != 1 || !Character.isLetter(inputedString.charAt(0))){
                output.println("Please input only one letter");
                inputedString = input.readLine();
            }

            game.guessLetter(inputedString);
        }
        output.println("stop");
    }
}

