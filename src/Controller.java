public class Controller {

    void run(){
        GameLogic gameLogic = new GameLogic();
        boolean keepRunning = true;
        do { //TODO possibly make class for actions
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +"Player Turn"+ ConsoleColors.RESET);
            switch (gameLogic.playerAction()) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 'b' -> gameLogic.dropBomb();
                case 'd' -> gameLogic.detonateBomb();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
            }

            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                    "Enemy Turn" + ConsoleColors.RESET);
            switch (gameLogic.enemyAction()) {
                case 'f' -> gameLogic.enemyForward();
                case 'r' -> gameLogic.enemyRetreat();
                case 'a' -> gameLogic.enemyAttack();
                //case dropBomb -> gameLogic.enemyDropBomb();
                //case detonateBomb -> gameLogic.enemyDetonateBomb();
                //case surrender -> GameLogic.surrender();
            }

        } while (keepRunning); //TODO make a while condition
    }

//TODO Discus making another class for main
    public static void main(String[] args) {
        Controller controller = new Controller();
        GameLogic game = new GameLogic();
        game.startGame();
        controller.run();
    }
}
