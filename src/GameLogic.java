public class GameLogic {
    Die die1 = new Die();
    Player player = new Player(10);
    Player enemy = new Player(-10);
    /*
    private String attack;
    private String forward;
    private String retreat;
    private boolean surrender;
    private boolean dropBomb;
    private boolean detonateBomb;
    private String showStats;

 */

     void attack(){

    }
    void forward(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2, 3 -> player.setPosition(player.getPosition() + 1);
             case 4, 5, 6 -> player.setPosition(player.getPosition() + 2);
         }
        System.out.println("Player has moved forward and is now at position " + player.getPosition());
    }
    void retreat(){
         die1.rollDie();
         switch (die1.getDie()){
             case 1, 2 -> player.setPosition(player.getPosition() - 1);
             case 3, 4 -> player.setPosition(player.getPosition() - 2);
             case 5, 6 -> player.setPosition(player.getPosition() - 3);
         }
        System.out.println("Player has retreated and is now at position "+ player.getPosition());
    }
    void surrender(){
         player.setAlive(false);
    }
    void dropBomb(){

    }
    void detonateBomb(){

    }
    void showStats(){

    }

    void enemyAttack(){

    }
    void enemyForward(){

    }
    void enemyRetreat(){

    }
}
