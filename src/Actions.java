/*public class Actions {
    GameLogic gameLogic = new GameLogic();

    void playerActionsHome(char input) {
        switch (input) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsAway(char input){
        switch (input) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 'b' -> gameLogic.dropBomb();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsDroppedBomb(char input){
        switch (input) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 'd' -> gameLogic.detonateBomb();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    void playerActionsUsedBomb(char input){
        switch (input) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
        }
    }

    public void playerActions(){
        char input = gameLogic.playerActionInput();
        if (gameLogic.player.isBombUsed()) {
            playerActionsUsedBomb(input);
        } else if (!gameLogic.player.getBomb()){
            playerActionsDroppedBomb(input);
        } else if (gameLogic.player.getPosition() < 0){
            playerActionsAway(input);
        } else if (gameLogic.player.getPosition() >= 0){
            playerActionsHome(input);
        }
    }
}*/
