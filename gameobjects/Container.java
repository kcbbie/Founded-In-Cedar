package gameobjects;

import java.util.ArrayList;

/**
 * Represents a container; a Thing that contains other Things.
 */
public class Container extends Thing {
    private ArrayList<Thing> contents;

    /**
     * Constructs a new Container.
     * @param initName - the Container's name
     * @param initDesc - the Container's description
     * @param initContents - the Container's contents
     */
    public Container(String initName, String initDesc, ArrayList<Thing> initContents) {
        super(initName, initDesc);
        contents = initContents;
    }

    /**
     * Get the contents of a Container.
     * @return the ArrayList<Thing> of contents
     */
    public ArrayList<Thing> getContents() {
        return contents;
    }

    /**
     * Set the contents of a Container to a given ArrayList<Thing>
     * @param newContents - the new contents being set to the container
     */
    public void setContents(ArrayList<Thing> newContents) {
        contents = newContents;
    }

    /**
     * Add a Thing to the Container.
     * @param t - the Thing being added
     */
    public void add(Thing t) {
        contents.add(t);
    }

    /**
     * Remove a thing from the Container.
     * (Obviously this doesn't really work right now).
     * @param t - the Thing being removed.
     */
    public void remove(Thing t) {
        contents.remove(t);
    }
}