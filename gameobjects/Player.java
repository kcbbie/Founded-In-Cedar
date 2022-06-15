package gameobjects;

import java.util.ArrayList;

/**
 * Represents the player/user.
 * Also contains some commands (take, look).
 */
public class Player extends Container {
    private Journal journal;
    private Room location;

    /**
     * Constructs a new Player
     * @param initName - the player's name
     * @param  initDesc - the player's desc
     * @param  initInv - the player's starting inventory
     * @param  initJournal - the player's starting journal
     * @param  initLocation - the player's starting location
    */
    public Player(String initName, String initDesc, ArrayList<Thing> initInv, 
                  Journal initJournal, Room initLocation) {
        super(initName, initDesc, initInv);
        journal = initJournal;
        location = initLocation;
    }

    /**
     * Get the player's journal.
     * @return the Journal
     */
    public Journal getJournal() {
        return journal;
    }

    /**
     * Set the player's journal to a given journal.
     * @param j - the journal being taken in
     */
    public void setJournal(Journal j) {
        journal = j;
    }

    /**
     * Get the player's location
     * @return the Room the Player is in
     */
    public Room getLocation() {
        return location;
    }

    /**
     * Set the player's location to a given room
     * @param r - the room being taken in
     */
    public void setLocation(Room r) {
        location = r;
    }

    /**
     * Displays the player's inventory.
     * @return a String containing the inventory information.
    */
    public String displayInv() {
        String s = "";
        for (int i = 0; i < getContents().size(); i++) {
            s = i + ". " + getName() + " - " + getDesc() + "\n";
        }
        return s;
    }

    public void displayJournal() {
        journal.display();
    }

    public void addPage(Page p) {
        journal.addPage(p);
    }

    /**
     * Takes an item from the player's environment and moves it to the player's inventory. Bug: doesn't work with items longer than 1 word
     * @param input - the item being taken
     * @return a confirmation/error String
    */
    public String take(String input) {
        boolean isInLocation = false;
        int itemIndex = 0;
        String s = "";
        for (int i = 0; i < location.getContents().size(); i++) {
            String currentContent = location.getContents().get(i).getName().toLowerCase();
            if (currentContent.equals(input.trim().toLowerCase())) {
                isInLocation = true;
                itemIndex = i;
            }
        }

        if (isInLocation) {
            Thing t = location.getContents().get(itemIndex);
            if (t.isTakeable()) {
                add(t);
                location.remove(t); 
                s = "You took the " + t.getName().toUpperCase() + ".";
            } else {
                System.out.println("\"" + t.getName() + "\" is not takeable.");
            }
        } else {
            s = "\"" + input + "\" is not in this location.";
        }
        return s;
    }

    /**
     * Look at/describe an object in the player's surroundings. Bug: doesn't work with items longer than 1 word
     * @param input - the thing being looked at
     * @return a description/error String
     */
    public String look(String input) {
        boolean isInLocation = false;
        int itemIndex = 0;
        String s = "";
        for (int i = 0; i < location.getContents().size(); i++) {
            String currentContent = location.getContents().get(i).getName().toLowerCase();
            if (currentContent.equals(input.trim().toLowerCase())) {
                isInLocation = true;
                itemIndex = i;
            }
        }
 
        if (isInLocation) {
		    Thing t = location.getContents().get(itemIndex);
            s += "You look at the " + input.toUpperCase() + ".";
		    s += t.getDesc();
	    } else {
		    s = "\"" + input + "\" is not in this location.";
	    }
	    return s;
    }
}