public class Controller {

    void run(){
        Die die1 = new Die();
        Player player = new Player(25,true,10,true,2500);
        Player enemy = new Player(25,true,-10,true,2500);
        boolean playeralive = player.isAlive();
        boolean enemyalive = enemy.isAlive();
        do {
            switch (playeraction) {
                case forward -> player.forward;
                case retreat -> player.retreat;
                case attack -> player.attack;
                case dropBomb -> player.dropBomb;
                case detonateBomb -> player.detonateBomb;
                case showStats -> player.showStats;
                case surrender -> player.surrender;
            }

            switch (enemyaction) {
                case forward -> player.forward;
                case retreat -> player.retreat;
                case attack -> player.attack;
                case dropBomb -> player.dropBomb;
                case detonateBomb -> player.detonateBomb;
                //case showStats -> player.showStats;
                //case surrender -> player.surrender;
            }

        } while (playeralive || enemyalive)
    }


    public static void main(String[] args) {
        Die die1 = new Die();
        die1.rollDie();
        System.out.println(die1.getDie());
        die1.rollDie();
        System.out.println(die1.getDie());
        die1.rollDie();
        System.out.println(die1.getDie());
    }
}
