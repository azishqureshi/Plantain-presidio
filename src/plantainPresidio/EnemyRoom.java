package plantainPresidio;
import java.util.Scanner;

public class EnemyRoom extends DefaultRoom {
	
    private boolean enemyAlive = true;
    private int enemyHealth = 5;
    Scanner input = new Scanner(System.in);

    EnemyRoom(int roomX, int roomY, boolean left, boolean right, boolean up, boolean down) {
        super(roomX, roomY, left, right, up, down);
    }

    @Override
    void roomAction() {
        //Skip action if enemy already defeated
        if (!enemyAlive) {
            System.out.println("The room is empty. You already defeated the enemy here.");
            return;
        }
        //Begin combat encounter
        System.out.println("An enemy appears!");
        printEnemyArt();

        //Combat loop: runs while enemy and player are alive
        while (enemyAlive && !Main.joey.noHealth()) {
            System.out.println("What would you like to do?");
            System.out.println("[P] Consume healing potion | [A] Attack the enemy");
            String choice = input.nextLine().trim().toLowerCase();
            switch (choice) {
                case "p":
                    //Use healing potion
                    if (Main.joey.getHealingItems() > 0) {
                        Main.joey.addHealingItems(-1);
                        Main.joey.heal(3);
                        System.out.println("Healed! Health is now: " + Main.joey.getHealth());
                    }
                    else {
                        System.out.println("You have no healing potions!");
                    }
                    break;
                case "a":
                    //Attack the enemy
                    System.out.println("Attacking!");
                    enemyHealth -= Main.joey.getAttack();

                    if (enemyHealth > 0) {
                        System.out.println("Hit! Enemy health at " + enemyHealth);
                        System.out.println("The enemy is attacking!");
                        Main.joey.takeDamage(1);
                        System.out.println("Your health is at " + Main.joey.getHealth());
                    }
                    else {
                        System.out.println("The enemy has died, and this room is now cleared");
                        enemyAlive = false;
                        roomActivated = true;
                        System.out.println("You found a healing potion!");
                        Main.joey.addHealingItems(1);
                    }
                    break;
                default:
                    System.out.println("Invalid input. Choose A or P.");
            }
            //Trigger game over if player dies
            if (Main.joey.noHealth()) {
                GameOver.checkGameOver();
            }
        }
    }
    //Prints room layout
    private void printEnemyArt() {
        System.out.println("==================]            [==================");
        System.out.println("|                      *                         |");
        System.out.println("|                     /|\\                        |");
        System.out.println("|                      |                         |");
        System.out.println("|                     / \\                        |");
        System.out.println("|                                                |");
        System.out.println("/                                                |");
        System.out.println("                                                 |");
        System.out.println("                                                 |");
        System.out.println("\\                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("==================]            [==================");
    }
}