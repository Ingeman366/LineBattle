public class Controller {

    void run(){
        GameLogic gameLogic = new GameLogic();
        UI ui = new UI();
        boolean keepRunning = true;
        do { //TODO possibly make class for actions as we can make it so it differs depending on things
            ui.playerTurn();
            switch (gameLogic.playerActionInput()) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 'b' -> gameLogic.dropBomb();
                case 'd' -> gameLogic.detonateBomb();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
            }
            if (!gameLogic.checkEnemyAlive() || !gameLogic.checkPlayerAlive()){
                keepRunning = false;
                break;
            }
            ui.enemyTurn();
            switch (gameLogic.enemyAction()) {
                case 'f' -> gameLogic.enemyForward();
                case 'r' -> gameLogic.enemyRetreat();
                case 'a' -> gameLogic.enemyAttack();
                //case dropBomb -> gameLogic.enemyDropBomb();
                //case detonateBomb -> gameLogic.enemyDetonateBomb();
                //case surrender -> GameLogic.surrender();
            }
            if (!gameLogic.checkPlayerAlive() || !gameLogic.checkEnemyAlive()){
                keepRunning = false;
                break;
            }
        } while (keepRunning);
    }

//TODO Discus making another class for main
    public static void main(String[] args) {
        Controller controller = new Controller();
        GameLogic game = new GameLogic();
        game.startGame();
        controller.run();
    }
}
