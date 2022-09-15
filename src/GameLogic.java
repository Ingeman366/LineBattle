import java.util.Scanner;

public class GameLogic {
    Scanner in = new Scanner(System.in);
    Die die1 = new Die();
    UI ui = new UI();
    Player player = new Player(10 - (die1.rollAndGetDie())-1);
    Player enemy = new Player(-10 + (die1.rollAndGetDie())-1);

    char playerAction(){
        scoutReport();
        if (player.getPosition() >= 0) {
            ui.playerActionsHome();
        } else if (player.getPosition() < 0){
            ui.playerActionsAway();
        } else if (!player.getBomb()){
            ui.playerActionsDroppedBomb();
        } else if (player.bombUsed){
            ui.playerActionsNoBomb();
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
//TODO make attack
    }
    void forward() {
        die1.rollDie();
        if (player.getPosition() == -10){
            System.out.println("Player is at the end of the board and can't move any further");
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
                 System.out.println("Player has retreated and is now back at base where they have been rearmed");
             } else {
                 System.out.println("Player has retreated and is now at position " + player.getPosition() + "\n");
             }
         }
    }
    void surrender(){
         player.setAlive(false); //TODO Check whether this works
    }
    void dropBomb(){
        player.setBombPosition(player.getPosition());
        player.setBomb(false);
        System.out.println("You have dropped the bomb at position " + player.getBombPosition());
    } //TODO make it so that you can only drop one bomb
    void detonateBomb(){
        int bombPostion = player.getBombPosition();
        if (bombPostion == -10) {
            System.out.println("You have detonated the bomb," +
                    " at the players headquarters and destroyed their army");
            //TODO make something that kills enemy
        } else {
            System.out.println("You have detonated the bomb and hit "); //TODO need attack to determine number of dead solders
        }
        player.bombUsed = true;
    }
    void showStats(){
        System.out.printf("Player position: %d \nPlayer firepower: %d \nPlayer troops: %d \nPlayer bomb: %b\n\n",
                player.getPosition(), player.getFirepower(), player.getTroops(), player.getBomb());
        System.out.printf("Enemy position: %d \nEnemy firepower: %d \nEnemy troops: %d \nEnemy bomb: %b\n\n",
                enemy.getPosition(), enemy.getFirepower(), enemy.getTroops(), enemy.getBomb());
    }

    void enemyAttack(){
//TODO make enemyAttack
        System.out.println("Enemy attacked\n");
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
         switch (die1.getDie()){
             case 1, 2 -> enemy.setPosition(enemy.getPosition() - 1);
             case 3, 4 -> enemy.setPosition(enemy.getPosition() - 2);
             case 5, 6 -> enemy.setPosition(enemy.getPosition() - 3);
         }
        System.out.println("Enemy has retreated\n");
         if (enemy.getPosition() < -10){
             enemy.setPosition(-10);
         } //TODO double check this solution
    }

    void scoutReport(){
        int distanceBetween = (player.getPosition()- enemy.getPosition());
        switch (distanceBetween) {
            case 1,2 -> System.out.printf("\u001B[41m\u001B[30mWatch out! The enemy is now %d %s IN FRONT of " +
                    "you\u001B[0m\n", distanceBetween, (distanceBetween==1? "field" : "fields"));
            case -1,-2,-3 -> System.out.printf("\u001B[41m\u001B[30mWatch out! The enemy is now %d %s BEHIND " +
                    "you\u001B[0m\n", Math.abs(distanceBetween), (Math.abs(distanceBetween)==1? "field" : "fields"));
            case 0 -> System.out.println("Watch out! The enemy is now in the same field as you\n");
        }
    }

    void enemyDropBomb() { //TODO create enemyDrobBomb when all else is done
    }

    void enemyDetonateBomb() { //TODO create enemyDetonateBomb when all else is done
    }

    void startGame(){
        ui.startMenu();
        in.nextLine();
    }
}
