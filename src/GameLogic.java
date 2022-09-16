import java.util.Scanner;

public class GameLogic {
    Scanner in = new Scanner(System.in);
    Die die1 = new Die();
    UI ui = new UI();
    Player player = new Player(10 - (die1.rollAndGetDie())-1);
    Player enemy = new Player(-10 + (die1.rollAndGetDie())-1);

    char playerActionInput(){
        scoutReport();
        int distanceBetween = Math.abs((player.getPosition()- player.getBombPosition()));
        if (player.isBombUsed()) {
            ui.playerActionsNoBomb();
        } else if (!player.getBomb() && distanceBetween > 6){
            ui.playerActionsDroppedBomb();
        } else if (!player.getBomb()){
            ui.playerActionsHome();
        }else if (player.getPosition() < 0){
            ui.playerActionsAway();
        } else if (player.getPosition() >= 0){
            ui.playerActionsHome();
        }
        String input = in.nextLine();
        while(input.isEmpty()){
            System.out.println("Please choose and action");
            input = in.nextLine();
        }
        return input.charAt(0);
    }

    char enemyAction(){ //TODO expand enemy actions to have more actions
        char eAction = '0';
        int action = die1.rng.nextInt(3)+1;
        switch (action){
            case 1 -> eAction = 'f';
            case 2 -> eAction = 'r';
            case 3 -> eAction = 'a';
        }
        return eAction;
    }

     void attack(){
        die1.rollDie();
        if (player.getFirepower() < (die1.getDie()*100)){
            System.out.println("You dont have enough firepower to fire as you rolled " + die1.getDie());
        } else {
            player.setFirepower(player.getFirepower() - (die1.getDie() * 100));
            int distanceBetween = Math.abs((player.getPosition() - enemy.getPosition()));
            switch (distanceBetween) {
                case 0 -> {
                    enemy.setTroops(enemy.getTroops() - 6);
                    System.out.println("You hit the enemy and killed 6 troops\n");
                }
                case 1 -> {
                    enemy.setTroops(enemy.getTroops() - 5);
                    System.out.println("You hit the enemy and killed 5 troops\n");
                }
                case 2 -> {
                    enemy.setTroops(enemy.getTroops() - 4);
                    System.out.println("You hit the enemy and killed 4 troops\n");
                }
                case 3 -> {
                    enemy.setTroops(enemy.getTroops() - 3);
                    System.out.println("You hit the enemy and killed 3 troops\n");
                }
                case 4 -> {
                    enemy.setTroops(enemy.getTroops() - 2);
                    System.out.println("You hit the enemy and killed 2 troops\n");
                }

                case 5 -> {
                    enemy.setTroops(enemy.getTroops() - 1);
                    System.out.println("You hit the enemy and killed 1 troops\n");
                }

                default -> System.out.println("You missed, Enemy too far away\n");
            }
            if (enemy.getTroops() <= 0) {
                System.out.println("You have killed all enemy troops\n");
                enemy.setAlive(false);
            }
        }
    }

    void forward() {
        die1.rollDie();
        if (player.getPosition() == -10){
            System.out.println("Player is at the end of the board and can't move any further\n");
        } else if (player.getPosition() == -9){
            player.setPosition(player.getPosition()-1);
            System.out.println("Player has moved forward and is now at position " + player.getPosition() + "\n");
        } else {
            switch (die1.getDie()){
                case 1, 2, 3 -> player.setPosition(player.getPosition() - 1);
                case 4, 5, 6 -> player.setPosition(player.getPosition() - 2);
            }
            System.out.println("Player has moved forward and is now at position " + player.getPosition() + "\n");
        }
    }
    void retreat(){
         die1.rollDie();
         player.setFirepower(player.getFirepower()+250);
         if (player.getPosition() == 10){
             System.out.println("Player is already back at base and cannot go further backwards");
         } else {
             switch (die1.getDie()) {
                 case 1, 2 -> player.setPosition(player.getPosition() + 1);
                 case 3, 4 -> player.setPosition(player.getPosition() + 2);
                 case 5, 6 -> player.setPosition(player.getPosition() + 3);
             }
             if (player.getPosition() > 10) {
                 player.setPosition(10);
             }
             if (player.getPosition() == 10) {
                 System.out.println("Player has retreated and is now back at base where they have been rearmed\n");
                 if (player.getBombPosition() < 0) {
                     player.getBombPosition();
                 } else {
                     player.setBomb(true);
                     player.setBombUsed(false);
                 }
             } else {
                 System.out.println("Player has retreated and is now at position " + player.getPosition() + "\n");
             }
         }
    }
    void surrender(){
        player.setAlive(false);
        player.setSurrendered(true);
    }
    void dropBomb(){
        player.setBombPosition(player.getPosition());
        player.setBomb(false);
        System.out.println("You have dropped the bomb at position " + player.getBombPosition());
    }
    void detonateBomb(){
        int bombPostion = player.getBombPosition();
        if (bombPostion == -10) {
            System.out.println("You have detonated the bomb," +
                    " at the players headquarters and destroyed their army\n");
            enemy.setAlive(false);
            enemy.setTroops(0);
        } else {
            System.out.println("You have detonated the bomb");
            int distanceBetween = Math.abs((player.getBombPosition()- enemy.getPosition()));
            switch (distanceBetween){
                case 0 -> {
                    enemy.setTroops(enemy.getTroops() - 6);
                    System.out.println("You hit the enemy and killed 6 troops\n");
                }
                case 1 -> {
                    enemy.setTroops(enemy.getTroops() - 5);
                    System.out.println("You hit the enemy and killed 5 troops\n");
                }
                case 2 -> {
                    enemy.setTroops(enemy.getTroops() - 4);
                    System.out.println("You hit the enemy and killed 4 troops\n");
                }
                case 3 -> {
                    enemy.setTroops(enemy.getTroops() - 3);
                    System.out.println("You hit the enemy and killed 3 troops\n");
                }
                case 4 -> {
                    enemy.setTroops(enemy.getTroops() - 2);
                    System.out.println("You hit the enemy and killed 2 troops\n");
                }

                case 5 -> {
                    enemy.setTroops(enemy.getTroops() - 1);
                    System.out.println("You hit the enemy and killed 1 troops\n");
                }

                default -> System.out.println("You missed, Enemy too far away\n");
            }
            if (enemy.getTroops() <= 0){
                System.out.println("You have killed all enemy troops\n");
                enemy.setAlive(false);
            }
        }
        player.setBombUsed(true);
    }
    void showStats(){
        System.out.printf("Player position: %d \nPlayer firepower: %d \nPlayer troops: %d \nPlayer bomb: %b\n\n",
                player.getPosition(), player.getFirepower(), player.getTroops(), player.getBomb());
        System.out.printf("Enemy position: %d \nEnemy firepower: %d \nEnemy troops: %d \nEnemy bomb: %b\n\n",
                enemy.getPosition(), enemy.getFirepower(), enemy.getTroops(), enemy.getBomb());
    }

    void enemyAttack(){
        die1.rollDie();
        if (enemy.getFirepower() < (die1.getDie()*100)){
            System.out.println("Enemy tried to attack but does not have enough firepower\n");
        } else {
            enemy.setFirepower(enemy.getFirepower() - (die1.getDie() * 100));
            int distanceBetween = Math.abs((enemy.getPosition() - player.getPosition()));
            switch (distanceBetween) {
                case 0 -> {
                    player.setTroops(player.getTroops() - 6);
                    System.out.println("Enemy attacked and killed 6 troops of yours\n");
                }
                case 1 -> {
                    player.setTroops(player.getTroops() - 5);
                    System.out.println("Enemy attacked and killed 5 troops of yours\n");
                }
                case 2 -> {
                    player.setTroops(player.getTroops() - 4);
                    System.out.println("Enemy attacked and killed 4 troops of yours\n");
                }
                case 3 -> {
                    player.setTroops(player.getTroops() - 3);
                    System.out.println("Enemy attacked and killed 3 troops of yours\n");
                }
                case 4 -> {
                    player.setTroops(player.getTroops() - 2);
                    System.out.println("Enemy attacked and killed 2 troops of yours\n");
                }
                case 5 -> {
                    player.setTroops(player.getTroops() - 1);
                    System.out.println("Enemy attacked and killed 1 troops of yours\n");
                }

                default -> System.out.println("Enemy attacked but missed\n");
            }
            if (player.getTroops() <= 0) {
                System.out.println("All your troops are dead and you have lost\n");
                player.setAlive(false);
            }
        }
    }
    void enemyForward(){
        die1.rollDie();
            switch (die1.getDie()){
                case 1, 2, 3 -> enemy.setPosition(enemy.getPosition() + 1);
                case 4, 5, 6 -> enemy.setPosition(enemy.getPosition() + 2);
            }
        System.out.println("Enemy has moved forward\n");
        if (enemy.getPosition() > 10){
            enemy.setPosition(10);
        }
    }
    void enemyRetreat(){
         die1.rollDie();
         enemy.setFirepower(enemy.getFirepower() + 250);
         switch (die1.getDie()){
             case 1, 2 -> enemy.setPosition(enemy.getPosition() - 1);
             case 3, 4 -> enemy.setPosition(enemy.getPosition() - 2);
             case 5, 6 -> enemy.setPosition(enemy.getPosition() - 3);
         }
        System.out.println("Enemy has retreated\n");
         if (enemy.getPosition() < -10){
             enemy.setPosition(-10);
         }
    }

    void scoutReport(){
        int distanceBetween = (player.getPosition()- enemy.getPosition());
        switch (distanceBetween) {
            case 1,2 -> System.out.printf(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLACK_BOLD +
                    "Watch out! The enemy is now %d %s IN FRONT of " +
                    "you" + ConsoleColors.RESET + "\n", distanceBetween, (distanceBetween==1? "field" : "fields"));
            case -1,-2,-3 -> System.out.printf(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLACK_BOLD +
                    "Watch out! The enemy is now %d %s BEHIND " +
                    "you" + ConsoleColors.RESET + "\n", Math.abs(distanceBetween), (Math.abs(distanceBetween)==1? "field" : "fields"));
            case 0 -> System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLACK_BOLD +
                    "Watch out! The enemy is now in the same field as you" + ConsoleColors.RESET + "\n");
        }
    }
    public int enemyScoutReport(){
        int distanceToPlayer = (enemy.getPosition()-player.getPosition());
        return distanceToPlayer;
    }

    void enemyDropBomb() { //TODO create enemyDrobBomb when all else is done
    }

    void enemyDetonateBomb() { //TODO create enemyDetonateBomb when all else is done
    }

    void startGame(){
        ui.startMenu(); //TODO make start options MAYBE
        in.nextLine();
    }

    boolean checkPlayerAlive(){
        return player.getAlive();
    }

    boolean checkEnemyAlive(){
        return enemy.getAlive();
    }

    void gameEnd(){
        if (player.getSurrendered()){
            ui.playerSurrender();
        } else if (player.getTroops() == 0){
            ui.playerLost();
        } else if (enemy.getTroops() == 0){
            ui.playerWon();
        }

    }
}
