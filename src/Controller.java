public class Controller {

    void run(){
        boolean playeralive = player(alive);
        boolean enemyalive = player(alive);
        Player player = new Player();
        Player enemy = new Player();

        do {
            switch (playeraction) {
                case forward -> player.forward;
                case retreat -> player.retreat;
                case attack -> player.attack;
                case dropBomb -> player.dropBomb;
                case detonateBomb -> player.detonateBomb;
                case showStats -> player.showStats;
                case surrender -> player.surrender;
            }

            switch (enemyaction) {
                case forward -> player.forward;
                case retreat -> player.retreat;
                case attack -> player.attack;
                case dropBomb -> player.dropBomb;
                case detonateBomb -> player.detonateBomb;
                //case showStats -> player.showStats;
                //case surrender -> player.surrender;
            }

        } while (playeralive || enemyalive)
    }
    public static void main(String[] args) {

    }
}
