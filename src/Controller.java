public class Controller {

    void run(){
        GameLogic gameLogic = new GameLogic();
        UI ui = new UI();
        //Actions actions = new Actions();
        gameLogic.startGame();

        boolean keepRunning = true;
        do {
            ui.playerTurn();

            char input = gameLogic.playerActionInput();
            if (gameLogic.player.isBombUsed()) {
                switch (input) {
                    case 'f' -> gameLogic.forward();
                    case 'r' -> gameLogic.retreat();
                    case 'a' -> gameLogic.attack();
                    case 's' -> gameLogic.showStats();
                    case 'q' -> gameLogic.surrender();
                    default -> {
                        System.out.println("Action not possible");
                        //TODO make loop so you dont lose a turn
                    }
                }
            } else if (!gameLogic.player.getBomb()){
                switch (input) {
                    case 'f' -> gameLogic.forward();
                    case 'r' -> gameLogic.retreat();
                    case 'a' -> gameLogic.attack();
                    case 'd' -> gameLogic.detonateBomb();
                    case 's' -> gameLogic.showStats();
                    case 'q' -> gameLogic.surrender();
                }            } else if (gameLogic.player.getPosition() < 0){
                switch (input) {
                    case 'f' -> gameLogic.forward();
                    case 'r' -> gameLogic.retreat();
                    case 'a' -> gameLogic.attack();
                    case 'b' -> gameLogic.dropBomb();
                    case 's' -> gameLogic.showStats();
                    case 'q' -> gameLogic.surrender();
                }
            } else if (gameLogic.player.getPosition() >= 0) {
                switch (input) {
                    case 'f' -> gameLogic.forward();
                    case 'r' -> gameLogic.retreat();
                    case 'a' -> gameLogic.attack();
                    case 's' -> gameLogic.showStats();
                    case 'q' -> gameLogic.surrender();
                }
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
        gameLogic.gameEnd();
    }

}
