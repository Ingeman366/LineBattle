public class Controller {

    void run(){
        Die die1 = new Die();
        Player player = new Player(25,true,10,true,2500);
        Player enemy = new Player(25,true,-10,true,2500);
        boolean playeralive = player.isAlive();
        boolean enemyalive = enemy.isAlive();
        do {
            switch (playeraction) {
                case forward -> GameLogic.forward();
                case retreat -> GameLogic.retreat();
                case attack -> GameLogic.attack();
                case dropBomb -> GameLogic.dropBomb();
                case detonateBomb -> GameLogic.detonateBomb();
                case showStats -> GameLogic.showStats();
                case surrender -> GameLogic.surrender();
            }

            switch (enemyaction) {
                case forward -> GameLogic.forward();
                case retreat -> GameLogic.retreat();
                case attack -> GameLogic.attack();
                case dropBomb -> GameLogic.dropBomb();
                case detonateBomb -> GameLogic.detonateBomb();
                //case showStats -> GameLogic.showStats();
                //case surrender -> GameLogic.surrender();
            }

        } while (playeralive || enemyalive);
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
