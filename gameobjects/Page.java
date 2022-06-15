package gameobjects;

import game.*;

/**
 * Represent a Page (to be stored in a Journal).
 */
public class Page extends Thing {
    private String[] entries = {"","",""};
    // private String[] other = {"","","",""}; // not added yet, would be xtra notes ab an area

    /**
     * Constructs a new Page.
     */
    public Page() {
        super("Default page name" , "Default page desc");
    }

    /**
     * Constructs a new Page.
     * @param initName - the name of the Page
     * @param initDesc - the description of the Page
     */
    public Page(String initName, String initDesc) {
        super(initName, initDesc);
        entries[0] = initDesc;
    }

    /**
     * Adds a given String as a new entry on a Page.
     * @param input - the entry being added
     */
    public void addEntry(String input) {
        int newEntryNum = 0;
        for (int i = 0; i < 3; i++) {
            if (entries[i].isEmpty()) {
                newEntryNum = i;
                i = 3;
            }
        }
        entries[newEntryNum] = input;
    }
    
    /**
     * Displays the Page and its entries.
     * Need to adjust this so it returns a String with the page stuff instead of just printing
     * it so it works with the rest of the command methods (like take and look)
     */
    public void displayPage() {
        System.out.println("+---------------------------------------------------+");
        // Should probably figure out how to get this part (line 41 - line 49) to be shorter
        System.out.print("| " + getName());
        for (int j = getName().length() + 2; j < Words.MAX_LINE_LENGTH; j++) {
            System.out.print(" ");
        }
        System.out.println(" |");
        System.out.print("| " + getDesc());
        for (int j = getDesc().length() + 2; j < Words.MAX_LINE_LENGTH; j++) {
            System.out.print(" ");
        }
        System.out.println(" |");
        int fullEnt = 0;
        for (int i = 0; i < 3; i++) {
            if (!entries[i].equals("")) {
                fullEnt++;
            }
        }
        String s = "";
        for(int i = 0; i < fullEnt; i++) {
            System.out.print("| " + (i + 1) + ". ");
            String entry = entries[i];
            s = Words.textWrapper(entry);
        }
        System.out.println(s);
        System.out.println("+---------------------------------------------------+");
    }
}