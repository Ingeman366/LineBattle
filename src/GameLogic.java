import java.util.Scanner;

public class GameLogic {
    Scanner in = new Scanner(System.in);
    Die die1 = new Die();
    Player player = new Player(10); //TODO Update playerpositions to depend on dice roll
    Player enemy = new Player(-10); //TODO Update playerpositions to depend on dice roll

    char playerAction(){
        if (player.getPosition() > 0) {
            System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Show Stats(s)\s
                    5. Surrender(q)""");
        } else if (player.getPosition() < 0){
            System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Drop Bomb(b)\s
                    5. Show Stats(s)\s
                    6. Surrender(q)""");
        } else if (!player.getBomb()){
            System.out.println("""
                    Choose an action\s
                    1. Forward(f)\s
                    2. Retreat(r)\s
                    3. Attack(a)
                    4. Detonate Bomb(d)\s
                    5. Show Stats(s)\s
                    6. Surrender(q)""");
        } //TODO Finde en anden måde at printe detonate og lave endnu if else til dette f.eks.
        String input = in.nextLine();
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
    void forward(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2, 3 -> player.setPosition(player.getPosition() - 1);
             case 4, 5, 6 -> player.setPosition(player.getPosition() - 2);
         }
        System.out.println("Player has moved forward and is now at position " + player.getPosition() + "\n"); //TODO need limit to forward at -10
    }
    void retreat(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2 -> player.setPosition(player.getPosition() + 1);
             case 3, 4 -> player.setPosition(player.getPosition() + 2);
             case 5, 6 -> player.setPosition(player.getPosition() + 3);
         }
        System.out.println("Player has retreated and is now at position "+ player.getPosition() + "\n"); //TODO need limit to retreat at 10
    }
    void surrender(){
         player.setAlive(false);
    }
    void dropBomb(){
        player.setBombPosition(player.getPosition());
        player.setBomb(false);
    }
    void detonateBomb(){
        int bombPostion = player.getBombPosition();

    }
    void showStats(){
        System.out.printf("Player position: %d \nPlayer firepower: %d \nPlayer troops: %d \nPlayer bomb: %b\n\n",
                player.getPosition(), player.getFirepower(), player.getTroops(), player.getBomb());
        System.out.printf("Enemy position: %d \nEnemy firepower: %d \nEnemy troops: %d \nEnemy bomb: %b\n\n",
                enemy.getPosition(), enemy.getFirepower(), enemy.getTroops(), enemy.getBomb());
    }

    void enemyAttack(){ //TODO make enemyAttack

    }
    void enemyForward(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2, 3 -> enemy.setPosition(enemy.getPosition() + 1);
             case 4, 5, 6 -> enemy.setPosition(enemy.getPosition() + 2);
         }
        System.out.println("Enemy has moved forward\n"); //TODO need limit to forward at 10
    }
    void enemyRetreat(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2 -> enemy.setPosition(enemy.getPosition() - 1);
             case 3, 4 -> enemy.setPosition(enemy.getPosition() - 2);
             case 5, 6 -> enemy.setPosition(enemy.getPosition() - 3);
         }
        System.out.println("Enemy has retreated\n"); //TODO need limit to retreat at -10
    }

    void scoutReport(){
        int distanceBetween = (player.getPosition()- enemy.getPosition());
        switch (distanceBetween) {
        case 1,2:
            System.out.println("Pas på! Modstanderen står nu " + distanceBetween + " felter FORAN dig");
            break;
        case -1,-2,-3:
            System.out.println("Pas på! Modstanderen står nu " + Math.abs(distanceBetween) + " felter BAG dig");
            break;
        case 0:
            System.out.println("Watch out! Du står i samme felt som modstanderen");
            break;
        default:
            break;

        }
    }

    void enemyDropBomb() {
    }

    void enemyDetonateBomb() {
    }
}
