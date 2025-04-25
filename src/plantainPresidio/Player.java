package plantainPresidio;

public class Player {
    //Player stats and inventory
    private int health;
    private int totalPlantainChips;
    private int attack;
    private int totalHealingItems;
    private boolean inventory;
    private boolean endGame;
    
    public Player(int health, int totalHealingItems, int totalPlantainChips, int attack, boolean inventory){
        this.health = health;
        this.totalHealingItems = totalHealingItems;
        this.totalPlantainChips = totalPlantainChips;
        this.attack = attack;
        this.inventory = inventory;
    }
    //Return current health
    public int getHealth(){
        return health;
    }
    //Return attack value
    public int getAttack(){
        return attack;
    }
    //Return number of healing items
    public int getHealingItems(){
        return totalHealingItems;
    }
    //Return number of plantain chips
    public int getPlantainChips(){
        return totalPlantainChips;
    }
    //Add or consume healing items
    public void addHealingItems(int n){
        totalHealingItems += n;
    }
    //Add or consume plantain chips
    public void addPlantainChips(int n){
        totalPlantainChips += n;
    }
    //Apply damage to player
    public void takeDamage(int dmg){
        health -= dmg;
    }
    //Heal player
    public void heal(int amt){
        health += amt;
    }
    //Check if player is dead
    public boolean noHealth(){
        if (health <= 0){
            endGame = true;
        }
        return endGame;
    }
    //Show inventory when [I] pressed
    public void openInventory(){
        if (Main.movement.equals("i")){
            inventory = true;
        }
        if (inventory){
            System.out.println("\nInventory:");
            System.out.println("Plantain chips: " + totalPlantainChips + " (5 needed)");
            System.out.println("Healing potions: " + totalHealingItems);
            System.out.println();
            inventory = false;
        }
    }
}

	
	



