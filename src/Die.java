import java.util.Random;

public class Die {
    Random rng = new Random();

    public int getDie() {
        return value;
    }

    public void rollDie() {
        this.value = rng.nextInt(6)+1;
    }

    public int rollAndGetDie(){
        this.value = rng.nextInt(3)+1;
        return value;
    }

    private int value;





}
