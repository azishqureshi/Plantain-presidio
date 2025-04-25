package plantainPresidio;

public class StarterRoom extends DefaultRoom {

    StarterRoom(int roomX, int roomY, boolean left, boolean right, boolean up, boolean down) {
        super(roomX, roomY, left, right, up, down);
    }
    //Prints room layout (with an exit indicator)
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

        System.out.println("|                   |#=#==#=#|                   |");

        //Exit changes based on number of collected plantain chips
        if (Main.joey.getPlantainChips() >= 5) {
            System.out.println("==================]            [==================");
        } 
        else {
            System.out.println("===================]          [===================");
        }
    }
}