package plantainPresidio;

public class DefaultRoom {
	
    protected boolean left, right, up, down;
    protected int roomX, roomY;
    
    //Indicates whether the room has been activated
    protected boolean roomActivated = false;

    DefaultRoom(int roomX, int roomY, boolean left, boolean right, boolean up, boolean down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.roomX = roomX;
        this.roomY = roomY;
    }

    //Getter for room's X coordinate
    public int getX() {
        return roomX;
    }
    //Getter for room's Y coordinate
    public int getY() {
        return roomY;
    }
    //Getter for room's activation state
    public boolean getRoomState() {
        return roomActivated;
    }
    //Setter for room's activation state
    public void setRoomState(boolean state) {
        this.roomActivated = state;
    }
    //Prints room layout
    void printRoom() {
        if (up) {
            System.out.println("==================]            [==================");
        }
        else {
            System.out.println("==================================================");
        }

        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");

        if (left && right) {
            System.out.println("/                                                \\");
            System.out.println("                                                  ");
            System.out.println("                                                  ");
            System.out.println("\\                                                /");
        }
        else if (left) {
            System.out.println("/                                                |");
            System.out.println("                                                 |");
            System.out.println("                                                 |");
            System.out.println("\\                                                |");
        }
        else if (right) {
            System.out.println("|                                                \\");
            System.out.println("|                                                 ");
            System.out.println("|                                                 ");
            System.out.println("|                                                /");
        }

        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");

        if (down) {
            System.out.println("==================]            [==================");
        }
        else {
            System.out.println("==================================================");
        }
    }
    //Method to activate the room
    void roomAction() {
        roomActivated = true;
    }
    //Method to handle player movement
    public void checkMovement() {
        switch (Main.movement) {
            //Move up if allowed
            case "w":
                if (up) {
                    Main.playerY--;
                    System.out.println("Moved up!");
                }
                else {
                    System.out.println("You can't move up.");
                }
                break;
            //Move down if allowed
            case "s":
                if (down) {
                    Main.playerY++;
                    System.out.println("Moved down!");
                }
                else {
                    System.out.println("You can't move down.");
                }
                break;
            //Move left if allowed
            case "a":
                if (left) {
                    Main.playerX--;
                    System.out.println("Moved left!");
                }
                else {
                    System.out.println("You can't move left.");
                }
                break;
            //Move right if allowed
            case "d":
                if (right) {
                    Main.playerX++;
                    System.out.println("Moved right!");
                }
                else {
                    System.out.println("You can't move right.");
                }
                break;
            case "i":
                Main.joey.openInventory();
                break;
            //Handle invalid input
            default:
                System.out.println("Invalid input (use [W, A, S, D] or [I])");
        }
    }
}

