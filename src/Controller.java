public class Controller {

    void run(){
        GameLogic gameLogic = new GameLogic();

        boolean playeralive = player.isAlive();
        boolean enemyalive = enemy.isAlive();
        do {
            switch (gameLogic.playerAction()) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 'b' -> gameLogic.dropBomb();
                case 'd' -> gameLogic.detonateBomb();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
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
    }
}
