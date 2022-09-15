public class Actions {
    GameLogic gameLogic = new GameLogic();

    void playerActinsHome() {
        switch (gameLogic.playerActionInput()) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsAway(){
        switch (gameLogic.playerActionInput()) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 'b' -> gameLogic.dropBomb();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsDroppedBomb(){
        switch (gameLogic.playerActionInput()) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 'd' -> gameLogic.detonateBomb();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsUsedBomb(){
        switch (gameLogic.playerActionInput()) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }
}
