/* Azish Qureshi, William Dix
Nov 17, 2023
Plantain Presido
A text based adventure game

Updated by Azish Qureshi

Apr 25, 2025

- Introduced HealingRoom.java
- Updated navigation system
- Updated room styles
- Finished end sequence
*/

package plantainPresidio;
import java.util.Scanner;

public class Main {

    static Scanner playerMovement = new Scanner(System.in);
    public static DefaultRoom[] room = new DefaultRoom[40];
    public static int gameState = 0;
    public static boolean newRoom = true;
    public static int currentRoom = 0;
    public static int playerX = 1;
    public static int playerY = 1;
    public static String movement = "";
    public static Player joey = new Player(10, 0, 0, 1, false);

    public static void main(String[] args) {
        //Initialize input keys
        new Script().keys();
        //Manually assign the first 20 rooms
        room[0]  = new StarterRoom(1,1,false,true,false,true);
        room[1]  = new HealingRoom(2,1,true, true, false, false);
        room[2]  = new EnemyRoom  (3,1,true, false, false, true);
        room[3]  = new DefaultRoom(4,1,false,false,false,true);
        room[4]  = new SpecialRoom(5,1,false,true, false, true);
        room[5]  = new EnemyRoom  (6,1,true,  true, false, true);
        room[6]  = new HealingRoom(7,1,true,  true, false, false);
        room[7]  = new SpecialRoom(8,1,true,  true, false, true);
        room[8]  = new HealingRoom(9,1,true,  true, false, true);
        room[9]  = new DefaultRoom(10,1,true, false, false, true);
        room[10] = new EnemyRoom  (1,2,false,true, true, false);
        room[11] = new SpecialRoom(2,2,true, true, true,  false);
        room[12] = new SpecialRoom(3,2,true,  false, false, true);
        room[13] = new HealingRoom(4,2,false, true, false, true);
        room[14] = new EnemyRoom  (5,2,true,  false, true,  false);
        room[15] = new SpecialRoom(6,2,false,false,true,  true);
        room[16] = new EnemyRoom  (7,2,false, true, true,  false);
        room[17] = new HealingRoom(8,2,true,  true,  true, false);
        room[18] = new DefaultRoom(9,2,true,  false, true,  false);
        room[19] = new EnemyRoom  (10,2,false,false,true,  true);
        //Auto-generate remaining default rooms
        for (int i = 20; i < 40; i++) {
            int x = (i % 10) + 1;
            int y = (i / 10) + 1;
            room[i] = new DefaultRoom(x, y, false, false, false, false);
        }
        //Auto-connect adjacent rooms
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                if (i == j) {
                    continue;
                }
                DefaultRoom r = room[i];
                DefaultRoom s = room[j];
                if (r.getX()+1==s.getX() && r.getY()==s.getY()) {
                    r.right = true;
                    s.left = true;
                }
                if (r.getX()-1==s.getX() && r.getY()==s.getY()) {
                    r.left = true;
                    s.right = true;
                }
                if (r.getY()+1==s.getY() && r.getX()==s.getX()) {
                    r.down = true;
                    s.up = true;
                }
                if (r.getY()-1==s.getY() && r.getX()==s.getX()) {
                    r.up = true;
                    s.down = true;
                }
            }
        }
        //Main game loop
        while (gameState == 0) {
            if (newRoom) {
                for (int i = 0; i < room.length; i++) {
                    if (room[i].getX() == playerX && room[i].getY() == playerY) {
                        room[i].printRoom();
                        currentRoom = i;
                        newRoom = false;
                        System.out.println("X" + playerX + " Y" + playerY);

                        if (joey.getPlantainChips() >= 5) {
                            System.out.println("You have enough plantain chips! Return to the entrance (X1 Y1)");
                        }
                        if (!room[i].getRoomState()) {
                            room[i].roomAction();
                        }
                        break;
                    }
                }
            }
            System.out.println("Input movement direction, or [I] for inventory");
            movement = playerMovement.nextLine().trim().toLowerCase();
            room[currentRoom].checkMovement();
            newRoom = true;
            if (joey.getPlantainChips() >= 5 && playerX == 1 && playerY == 1) {
                System.out.println("You unseal the exit and leave the chamber. Now it's time to find your brother!");
                System.out.println(" _________  ___  ___  _______           _______   ________   ________     \n"
                        + "|\\___   ___\\\\  \\|\\  \\|\\  ___ \\         |\\  ___ \\ |\\   ___  \\|\\   ___ \\    \n"
                        + "\\|___ \\  \\_\\ \\  \\\\\\  \\ \\   __/|        \\ \\   __/|\\ \\  \\\\ \\  \\ \\  \\_|\\ \\   \n"
                        + "     \\ \\  \\ \\ \\   __  \\ \\  \\_|/__       \\ \\  \\_|/_\\ \\  \\\\ \\  \\ \\  \\ \\\\ \\  \n"
                        + "      \\ \\  \\ \\ \\  \\ \\  \\ \\  \\_|\\ \\       \\ \\  \\_|\\ \\ \\  \\\\ \\  \\ \\  \\_\\\\ \\ \n"
                        + "       \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\       \\ \\_______\\ \\__\\\\ \\__\\ \\_______\\\n"
                        + "        \\|__|  \\|__|\\|__|\\|_______|        \\|_______|\\|__| \\|__|\\|_______|");

                System.exit(0);
            }
        }
    }
}




