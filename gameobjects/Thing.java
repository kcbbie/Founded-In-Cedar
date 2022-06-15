package gameobjects;

/**
 * Represents any object. All other objects in this game stem from this class.
 */
public class Thing {
    private String name;
    private String desc;
    private boolean takeable;
    private boolean useable;

    /**
     * Constructs a new Thing.
     */
    public Thing() {
        name = "An unnamed thing.";
        desc = "An unspecified description.";
    }

    /**
     * Constructs a new Thing.
     * @param initName - the Thing's name
     * @param initDesc - the Thing's description
     */
    public Thing(String initName, String initDesc) {
        name = initName;
        desc = initDesc;
        takeable = false;
        useable = false;
    }

    /**
     * Constructs a new Thing (used for any takeable, but not useable items).
     * @param initName - the Thing's name
     * @param initDesc - the Thing's description
     * @param isTakeable - if you can take the Thing
     */
    public Thing(String initName, String initDesc, boolean isTakeable) {
        name = initName;
        desc = initDesc;
        takeable = isTakeable;
        useable = false;
    }

    /**
     * Constructs a new Thing (used for any useable items).
     * @param initName - the Thing's name
     * @param initDesc - the Thing's description
     * @param isTakeable - if you can take the Thing
     * @param isUseable - if you can use the Thing
     */
    public Thing(String initName, String initDesc, boolean isTakeable, boolean isUseable) {
        name = initName;
        desc = initDesc;
        takeable = isTakeable;
        useable = isUseable;
    }

    // GETTER/SETTER METHODS

    /**
     * Get the thing's name.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the thing's name to a given String
     * @param s - the new name.
     */
    public void setName(String s) {
        name = s;
    }

    /**
     * Get the thing's description.
     * @return the description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set the thing's description to a given String.
     * @param s - the new description.
     */
    public void setDesc(String s) {
        desc = s;
    }

    /**
     * If the thing is able to be taken.
     * @return true/false status of takeability.
     */
    public boolean isTakeable() {
        return takeable;
    }

    /**
     * Set the thing's takeability to a given boolean value.
     * @param b - the new boolean.
     */
    public void setTakeable(boolean b) {
        takeable = b;
    }

    /**
     * If the thing is able to be used
     * @return true/false status of usability.
     */
    public boolean isUseable() {
        return useable;
    }

    /**
     * Set the thing's usability to a given boolean value.
     * @param b - the new boolean value.
     */
    public void setUseable(boolean b) {
        useable = b;
    }
}