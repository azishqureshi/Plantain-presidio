package plantainPresidio;

public class SpecialRoom extends DefaultRoom {

    SpecialRoom(int roomX, int roomY, boolean left, boolean right, boolean up, boolean down) {
        super(roomX, roomY, left, right, up, down);
    }
    //Triggers when the player enters this room
    @Override
    void roomAction() {
        System.out.println("You found a plantain chip!");
        Main.joey.addPlantainChips(1);
        System.out.println("You now have " + Main.joey.getPlantainChips() + " plantain chips.");
        this.roomActivated = true;
    }
    //Prints room layout (with plantain chip)
    @Override
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
            System.out.println("                        **                        ");
            System.out.println("                        **                        ");
            System.out.println("\\                                                /");
        } 
        else if (left) {
            System.out.println("/                                                |");
            System.out.println("                        **                       |");
            System.out.println("                        **                       |");
            System.out.println("\\                                                |");
        } 
        else if (right) {
            System.out.println("|                                                \\");
            System.out.println("|                       **                        ");
            System.out.println("|                       **                        ");
            System.out.println("|                                                /");
        }

        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|                                                |");

        if (down) System.out.println("==================]            [==================");
        else      System.out.println("==================================================");
    }
}
