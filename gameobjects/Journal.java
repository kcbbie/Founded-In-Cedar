package gameobjects;

import java.util.ArrayList;

/**
 * Represents a Journal which contains Pages.
 */
public class Journal extends Thing {
    private ArrayList<Page> pages;

    /**
     * Constructs a new Journal.
     * @param initName - the Journal's name
     * @param initDesc - the Journal's desc
     * @param initPages - the Journal's starting pages
     */
    public Journal(String initName, String initDesc, ArrayList<Page> initPages) {
        super(initName, initDesc);
        pages = initPages;
    }

    /**
     * Add a page to the Journal.
     * @param p - the Page being added
     */
    public void addPage(Page p) {
        pages.add(p);
    }

    /**
     * Adds an entry to a particular page of the Journal.
     * @param pageNum - the number of the page it's being added on
     * @param entry - the text of the entry
     */
    public void addEntry(int pageNum, String entry) {
        pages.get(pageNum).addEntry(entry);
    }

    /**
     * Displays the entire Journal
     */
    public void display() {
        for (int i = 0; i < pages.size(); i++) {
            pages.get(i).displayPage();
        }
    }

    // GETTER/SETTER METHODS 
    
    /**
     * Get a certain Page from the Journal.
     * @param pageNum - the number of the Page
     * @return the Page corresponding to the number
     */
    public Page getPage(int pageNum) {
        return pages.get(pageNum);
    }

    /**
     * Get all the pages from the Journal.
     * @return the ArrayList<Page> that the Journal contains
     */
    public ArrayList<Page> getPages() {
        return pages;
    }
}