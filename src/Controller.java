public class Controller {
    void run(){
        GameLogic gameLogic = new GameLogic();
        UI ui = new UI();
        Actions actions = new Actions();
        gameLogic.startGame();
        int roundNumber = 0;

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
                            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                                    "Action not possible"+ ConsoleColors.RESET);
                            actions.playerActionsUsedBomb(gameLogic.playerActionInput());
                        }
                    }
                } else if (!gameLogic.player.getBomb()) {
                    switch (input) {
                        case 'f' -> gameLogic.forward();
                        case 'r' -> gameLogic.retreat();
                        case 'a' -> gameLogic.attack();
                        case 'd' -> gameLogic.detonateBomb();
                        case 's' -> gameLogic.showStats();
                        case 'q' -> gameLogic.surrender();
                        default -> {
                            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                                    "Action not possible"+ ConsoleColors.RESET);
                            actions.playerActionsDroppedBomb(gameLogic.playerActionInput());
                        }
                    }
                } else if (gameLogic.player.getPosition() < 0) {
                    switch (input) {
                        case 'f' -> gameLogic.forward();
                        case 'r' -> gameLogic.retreat();
                        case 'a' -> gameLogic.attack();
                        case 'b' -> gameLogic.dropBomb();
                        case 's' -> gameLogic.showStats();
                        case 'q' -> gameLogic.surrender();
                        default -> {
                            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                                    "Action not possible"+ ConsoleColors.RESET);
                            actions.playerActionsAway(gameLogic.playerActionInput());
                        }
                    }
                } else if (gameLogic.player.getPosition() >= 0) {
                    switch (input) {
                        case 'f' -> gameLogic.forward();
                        case 'r' -> gameLogic.retreat();
                        case 'a' -> gameLogic.attack();
                        case 's' -> gameLogic.showStats();
                        case 'q' -> gameLogic.surrender();
                        default -> {
                            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                                    "Action not possible"+ ConsoleColors.RESET);
                            actions.playerActionsHome(actions.inputNew());
                        }
                    }                    }

            if (!gameLogic.checkEnemyAlive() || !gameLogic.checkPlayerAlive()){
                keepRunning = false;
                break;
            }
            ui.enemyTurn();
            try {
                Thread.sleep(400);
                System.out.print(".");
                Thread.sleep(400);
                System.out.print(".");
                Thread.sleep(400);
                System.out.print(".");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            roundNumber += 1;
                if (roundNumber < 3) {
                    gameLogic.enemyForward();
                } else {
                    switch (gameLogic.enemyAction()) {
                        case 'f' -> gameLogic.enemyForward();
                        case 'r' -> gameLogic.enemyRetreat();
                        case 'a' -> gameLogic.enemyAttack();
                        //TODO case dropBomb -> gameLogic.enemyDropBomb();
                        //TODO case detonateBomb -> gameLogic.enemyDetonateBomb();
                    }
                }


            if (!gameLogic.checkPlayerAlive() || !gameLogic.checkEnemyAlive()){
                keepRunning = false;
                break;
            }
        } while (keepRunning);
        gameLogic.gameEnd();
    }

}
