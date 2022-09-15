import java.util.Scanner;

public class Actions {
    GameLogic gameLogic = new GameLogic();
    Scanner in = new Scanner(System.in);

    char inputNew(){
        String inNew = in.nextLine();
        return inNew.charAt(0);
    }

    void playerActionsHome(char input) {
        switch (input) {
            case 'f' -> gameLogic.forward();
            case 'r' -> gameLogic.retreat();
            case 'a' -> gameLogic.attack();
            case 's' -> gameLogic.showStats();
            case 'q' -> gameLogic.surrender();
            default -> {
                System.out.println("Action not possible");
                playerActionsHome(inputNew());
            }
            }
        }

        void playerActionsAway(char input2){
            switch (input2) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 'b' -> gameLogic.dropBomb();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
                default -> {
                    System.out.println("Action not possible");
                }
            }
        }

        void playerActionsDroppedBomb (char input){
            switch (input) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 'd' -> gameLogic.detonateBomb();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
            }
        }

        void playerActionsUsedBomb (char input){
            switch (input) {
                case 'f' -> gameLogic.forward();
                case 'r' -> gameLogic.retreat();
                case 'a' -> gameLogic.attack();
                case 's' -> gameLogic.showStats();
                case 'q' -> gameLogic.surrender();
            }
        }

        public void playerActions () {
            char input = gameLogic.playerActionInput();
            if (gameLogic.player.isBombUsed()) {
                playerActionsUsedBomb(input);
            } else if (!gameLogic.player.getBomb()) {
                playerActionsDroppedBomb(input);
            } else if (gameLogic.player.getPosition() < 0) {
                playerActionsAway(input);
            } else if (gameLogic.player.getPosition() >= 0) {
                playerActionsHome(input);
            }
        }
    }
