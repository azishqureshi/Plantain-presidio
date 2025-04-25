package plantainPresidio;
import java.util.Scanner;

public class Script {
    //Sets scriptState to 0, and instantiates TitleScreen
    TitleScreen start = new TitleScreen();
    int scriptState = 0;
    Scanner keyInput = new Scanner(System.in);

    public void keys () {
        //Display title screen and wait for start input
        TitleScreen.title();
        System.out.println("Press [C] to start");
        String key = keyInput.nextLine();
        //Start script intro
        if (key.toLowerCase().equals("c") && scriptState == 0) {
            System.out.println("Keys: [C] continue script, [I] inventory, [P] heal in combat, [A] attack in combat, [W, A, S, D] move around");
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            System.out.println("It was a Thursday afternoon and you were starving");
            System.out.println("Wait a second! Your brother owns a plantain mafia, there has to be food there! (Press 'C' to continue)");
            scriptState++;
        
        String key3 = keyInput.nextLine();
        //Script part 2
        if (key3.toLowerCase().equals("c") && scriptState == 1) {
            System.out.println("You make it to the plantain warehouse and just as you're about to take a bite, you're knocked out!");
            System.out.println("As you slowly regain consciousness, you see a blurry silhouette of someone in front of you. It's your brother, Don Plantano");
            scriptState++;
        }
        String key4 = keyInput.nextLine();
        //Script part 3
        if (key4.toLowerCase().equals("c") && scriptState == 2) {
            System.out.println("DON: You've been causing me a lot of trouble lately. My plantain chips reserves have been running low...");
            System.out.println("DON: All because you can't stop yourself from eating everything! I've had enough!");
            scriptState++;
        }
        String key5 = keyInput.nextLine();
        //Script part 4
        if (key5.toLowerCase().equals("c") && scriptState == 3) {
            System.out.println("Don's men grab you by your arms and throw you into a dark chamber");
            System.out.println("DON: This should take care of you. Who needs family anyways?");
            scriptState++;
        }
        String key6 = keyInput.nextLine();
        //Script part 5
        if (key6.toLowerCase().equals("c") && scriptState == 4) {
            System.out.println(" ");
            System.out.println("-----------------------------------------------------------");
            System.out.println(" ");
            System.out.println("It's dark and cold. You're still processing what happened, until suddenly an old man approaches you");
            System.out.println("OLD MAN: If you want to leave, I'm the only hope you have");
            scriptState++;
        }
        String key7 = keyInput.nextLine();
        //Script part 6 - mission explained
        if (key7.toLowerCase().equals("c") && scriptState == 5) {
            System.out.println("OLD MAN: There are 5 rooms located in this chamber, of the chamber. Each one contains modified plantain chips that increase your vigor");
            System.out.println("OLD MAN: The main exit at the bottom of this chamber is sealed off, but with enough vigor you could rip it open");
            System.out.println("OLD MAN: Oh! I forgot to mention. There's also healing potions. Some bad guys are lurking around here, so those would be useful");
            System.out.println("OLD MAN: Now go without me! I'm already living my final days");
            System.out.println(" ");
        }
        //Catches invalid inputs
        else {

        	}
        }
    }
}


