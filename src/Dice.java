import java.util.Random;

public class Dice {
    Random rng = new Random();
    private int value;

    public int rollDice(){
        return rng.nextInt(6)+1;
    }



}
