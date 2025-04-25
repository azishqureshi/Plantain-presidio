package plantainPresidio;

public class HealingRoom extends DefaultRoom {
    HealingRoom(int roomX, int roomY, boolean left, boolean right, boolean up, boolean down) {
        super(roomX, roomY, left, right, up, down);
    }
    @Override
    void roomAction() {
    	//Adds healing potion while notifying player
        System.out.println("You found a healing potion! (+1 healing item)");
        Main.joey.addHealingItems(1);
        this.roomActivated = true;
    }
}