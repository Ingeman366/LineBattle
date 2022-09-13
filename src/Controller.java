public class Controller {

    void run(){
        GameLogic gameLogic = new GameLogic();

        boolean playeralive = player.isAlive();
        boolean enemyalive = enemy.isAlive();
        do {
            switch (gameLogic.playerAction()) {
                case forward -> gameLogic.forward();
                case retreat -> gameLogic.retreat();
                case attack -> gameLogic.attack();
                case dropBomb -> gameLogic.dropBomb();
                case detonateBomb -> gameLogic.detonateBomb();
                case showStats -> gameLogic.showStats();
                case surrender -> gameLogic.surrender();
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
