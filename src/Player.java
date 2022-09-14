public class Player {
    private int troops = 25;
    private boolean bomb = true;
    private int position;
    private boolean alive = true; //TODO make something that checks alive
    private int firepower = 2500;
    private int bombPosition;
    public boolean bombUsed = false;



    public int getBombPosition() {
        return bombPosition;
    }

    public void setBombPosition(int bombPosition) {
        this.bombPosition = bombPosition;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public int getTroops() {
        return troops;
    }

    public void setTroops(int troops) {
        this.troops = troops;
    }

    public boolean getBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Player(int position) {
        this.position = position;

    }
}

