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
}
