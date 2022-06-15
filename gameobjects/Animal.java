package gameobjects;

/**
 * Represents an animal; the NPCS of this game.
 */
public class Animal extends Thing {
    private boolean talkable;
    // secondLine + thirdLine are the messages you'll add to your journal after speaking to the animal
    private String secondLine;
    private String thirdLine;
    // Character dialogue has not been written but not implemented yet
    // However, you can find the theoretical dialogue in the .txt file called "animal_dialogue.txt"
    // in the globals folder (I didn't know where else to put it)
    // private String[] dialogue = new String[4];
    // private int dialogueCounter = 0;

    /**
     * Constructs a new Animal with no unique information.
     */
    public Animal() {
        super("A character", "A character desc");
        talkable = true;
    }
    
    /**
     * Constructs a new Animal.
     * @param name - the Animal's name
     * @param desc - the Animal's desc
     * @param isTalkable - if you can talk to the Animal
     */
    public Animal(String name, String desc, boolean isTalkable) {
        super(name, desc);
        talkable = isTalkable;
    }

    /**
     * Constructs a new Animal.
     * @param name - the Animal's name
     * @param desc - the Animal's desc
     * @param isTalkable - if you can talk to the Animal
     * @param initSecondLine - one line the that will be added to your journal by talking to the Animal
     * @param initThirdLine - second line that will be added to your journal by speaking to them
     */
    public Animal(String name, String desc, boolean isTalkable, 
                  String initSecondLine, String initThirdLine/* , String[] initDialogue*/) {
        super(name, desc);
        talkable = isTalkable;
        secondLine = initSecondLine;
        thirdLine = initThirdLine;
        // dialogue = initDialogue;
    }

    /**
     * If you can talk to the Animal.
     * @return the boolean value
     */
    public boolean getTalkable() {
        return talkable;
    }

    /**
     * Set the talkable boolean to a given boolean value.
     * @param b - the given boolean value
     */
    public void setTalkable(boolean b) {
        talkable = b;
    }

    /**
     * Get the animal-based 2nd journal page entry.
     * @return the second line String
     */
    public String getSecondLine() {
        return secondLine;
    }

    /**
     * Get the animal-based 3rd journal page entry.
     * @return the third line String
     */
    public String getThirdLine() {
        return thirdLine;
    }
}