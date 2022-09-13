public class Player {
    private int troops;
    private boolean bomb;
    private int position;
    private boolean alive;
    private int firepower;

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

    public boolean isBomb() {
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Player(int troops, boolean bomb, int position, boolean alive, int firepower) {
        this.troops = troops;
        this.bomb = bomb;
        this.position = position;
        this.alive = alive;
        this.firepower = firepower;
    }
}

