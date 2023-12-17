package pkg;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HangmanInterface {
    private static final String password = "senha";
    private String[] savedGuess = new String[password.length()];
    private Integer lives;

    public HangmanInterface(Integer l){
        this.lives=l;
    }
    
    public String printLives(){
        return "You have " + this.lives.toString() + " lives";
    }

    public String printStatus(){
        return Arrays.stream(this.savedGuess)
                    .map(value -> value == null ? "_" : value)
                    .collect(Collectors.joining());
    }

    public void guessLetter(String guess){
        
        for (int i = 0; i<password.length(); i++){
            String comparingCharacter = Character.toString(password.charAt(i));
            if (guess.equals(comparingCharacter)){
                this.savedGuess[i]= comparingCharacter;
            }
        }
        
        if (!password.contains(guess)){
            this.lives = this.lives - 1 ;
        }
       
    }

    public Boolean isFinished(){
        if (this.lives.equals(0) || Arrays.stream(this.savedGuess)
                    .collect(Collectors.joining()).equals(HangmanInterface.password) ){
            return true;
        }
        return false;
    }

}
