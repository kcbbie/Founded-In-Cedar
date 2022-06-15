package gameobjects;

import java.util.ArrayList;

/**
 * Represents an area (inside or outside).
 */
public class Room extends Container {
    private Room north, south, east, west, up, down;

    /**
     * Constructs a new Room with no unique information.
    */ 
    public Room() {
        super("New Room", null, null);
        north = null;
        south = null;
        east = null;
        west = null;
        up = null;
        down = null;
    }

    /**
     * Initializes a Room with all of its relevant information (connecting rooms, contents, etc).
     * @param initName - the Room's name
     * @param initDesc - the Room's description
     * @param initContents - the Room's starting contents
     * @param initN, initS, initE, initW, initUp, initDown - the Rooms connecting to the Room from different directions
     */
    public void init(String initName, String initDesc, ArrayList<Thing> initContents, 
                Room initN, Room initS, Room initE, Room initW, Room initUp, Room initDown) {
        setName(initName);
        setDesc(initDesc);
        setContents(initContents);
        north = initN;
        south = initS;
        east = initE;
        west = initW;
        up = initUp;
        down = initDown;
    }

    /**
     * The room describes itself.
     * @return String containing the description + what's in the area.
     */
    public String describe() {
        String list = "";
        String s = super.getDesc();
        if (super.getContents().size() != 0) {
            list += super.getContents().get(0).getName().toUpperCase();
            for (int i = 1; i < super.getContents().size() - 1; i++) {
                list += ", " + super.getContents().get(i).getName().toUpperCase();
            }
            list += ", and a " + super.getContents().get(super.getContents().size() - 1).getName().toUpperCase();
            s += " Around you, you see a " + list + ".";
        } else {
            s += " There isn't anything to interact with.";
        }
        return s;
    }

    // GETTER/SETTER METHODS

    /**
     * Get the Room to the north of the Room.
     * @return the Room to the north.
     */
    public Room getNorth() {
        return north;
    }

    /**
     * Set the Room to the north of the Room to a given Room.
     * @param newNorth - the new Room to be set to north.
     */
    public void setNorth(Room newNorth) {
        north = newNorth;
    }

    /**
     * Get the Room to the south of the Room.
     * @return the Room to the south.
     */
    public Room getSouth() {
        return south;
    }

    /**
     * Set the Room to the south of the Room to a given Room.
     * @param newSouth - the new Room to be set to south.
     */
    public void setSouth(Room newSouth) {
        south = newSouth;
    }

    /**
     * Get the Room to the east of the Room.
     * @return the Room to the east.
     */
    public Room getEast() {
        return east;
    }

    /**
     * Set the Room to the east of the Room to a given Room.
     * @param newEast - the new Room to be set to east.
     */
    public void setEast(Room newEast) {
        east = newEast;
    }

    /**
     * Get the Room to the west of the Room.
     * @return the Room to the west.
     */
    public Room getWest() {
        return west;
    }

    /**
     * Set the Room to the west of the Room to a given Room.
     * @param newWest - the new Room to be set to west.
     */
    public void setWest(Room newWest) {
        west = newWest;
    }

    /**
     * Get the Room to the upward side of the Room.
     * @return the Room to the upward side.
     */
    public Room getUp() {
        return up;
    }

    /**
     * Set the Room to the upward side of the Room to a given Room.
     * @param newUp - the new Room to be set to the upward side.
     */
    public void setUp(Room newUp) {
        up = newUp;
    }

    /**
     * Get the Room to the downward side of the Room.
     * @return the Room to the downward side.
     */
    public Room getDown() {
        return down;
    }

    /**
     * Set the Room to the downward side of the Room to a given Room.
     * @param newDown - the new Room to be set to downward side.
     */
    public void setDown(Room newDown) {
        down = newDown;
    }
}
