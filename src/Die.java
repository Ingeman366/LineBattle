import java.util.Random;

public class Die {
    Random rng = new Random();

    public int getDie() {
        return value;
    }

    public void rollDie() {
        this.value = rng.nextInt(6)+1;
    }

    private int value;





}
