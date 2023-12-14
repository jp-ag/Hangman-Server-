package pkg;

public class HangmanInterface {
    private static final String password = "senha";
    private Integer lives;

    public HangmanInterface(Integer l){
        this.lives=l;
    }

    //TO DO guess logic then return current state
    public String guessLetter(String guess){
        return "a";
    }

    //TO DO check if lives are over or if word is complete
    public Boolean isFinished(){
        return false;
    }


}
