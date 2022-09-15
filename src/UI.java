public class UI {

    public void playerActionsHome(){
        System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Show Stats(s)\s
                    5. Surrender(q)""");
    }

    public void playerActionsAway(){
        System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Drop Bomb(b)\s
                    5. Show Stats(s)\s
                    6. Surrender(q)""");
    }

    public void playerActionsDroppedBomb(){
        System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Detonate Bomb(d)\s
                    5. Show Stats(s)\s
                    6. Surrender(q)""");
    }

    public void playerActionsNoBomb(){
        System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Show Stats(s)\s
                    5. Surrender(q)""");
    }

    public void startMenu(){
        System.out.println("""
                Hello Player, Welcome to the game\s
                Press ENTER to start the game\s""");
    }

    public void playerTurn(){
        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +"Player Turn"+ ConsoleColors.RESET);
    }

    public void enemyTurn(){
        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD +
                "Enemy Turn" + ConsoleColors.RESET);
    }

    public void playerWon(){
        System.out.println(ConsoleColors.BLACK_UNDERLINED +
                ConsoleColors.YELLOW_BACKGROUND +"CONGRATULATIONS YOU WON!!" + ConsoleColors.RESET);
    }

    public void playerSurrender(){

    }

    public void playerLost(){

    }
}
