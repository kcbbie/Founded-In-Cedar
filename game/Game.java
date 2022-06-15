package game;

import gameobjects.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents the game currently being played.
 */
public class Game {
    private ArrayList<Room> map;       //name          desc               inv
    private Player player = new Player("Player Name", "A lovely player.", new ArrayList<Thing>(), 
                                        new Journal("Journal", "Journal desc", new ArrayList<Page>()), null);
                                       //journal                                                       location

    /**
     * 
     */
    public Game() {
        Words.initVocab();
        initGame();
    }

    /**
     * Prints the intro text and collects the players name.
    */ 
    public void intro() {
        System.out.println("______                     _          _    _           ____         _            ");
        System.out.println("|  ___|__  _   _ _ __   __| | ___  __| |  (_)_ __     / ___|___  __| | __ _ _ __ ");
        System.out.println("| |_ / _ \\| | | | '_ \\ / _` |/ _ \\/ _` |  | | '_ \\   | |   / _ \\/ _` |/ _` | '__|");
        System.out.println("|  _| (_) | |_| | | | | (_| |  __/ (_| |  | | | | |  | |__|  __/ (_| | (_| | |   ");
        System.out.println("|_|  \\___/ \\__,_|_| |_|\\__,_|\\___|\\__,_|  |_|_| |_|   \\____\\___|\\__,_|\\__,_|_|");
        System.out.println(" +-----------------------------------------------------------------------------+");
        System.out.println(" |                Developed by Kate Brooks and Blake Chandler                  |");
        System.out.println(" |                      Enter 'help' to see all commands.                      |");
        System.out.println(" |                             Enter 'q' to quit.                              |");
        System.out.println(" +-----------------------------------------------------------------------------+");
        System.out.println("You have found yourself laying in a quaint clearing; trees surround\n" + 
                           "you. From your grounded view, you see a few birds above and you feel the\n" +
                           "warm sun on your face. You don't remember how you got there.");
        System.out.println();
        System.out.println("The scent of charcoal wafts over you. Upon sitting up and looking\n" +
                           "around, you notice a few things scattered closely: a JOURNAL with a\n" +
                           "pen, and a marked paper.");
        System.out.println();
        System.out.print("You pick up the JOURNAL and see an empty name spot. You feel like \n" + 
                         "you should write your name: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name= "";
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setName(name);
        System.out.println(player.getLocation().describe());
    }

    /**
     * Initiliazes all the game objects (exluding the player)
     * Unfinished in the grand scheme of the game.
     * Also could probably be more organized...
     */
    public void initGame() {
        // MAP STUFF
        map = new ArrayList<Room>();

        // ROOMS
        
        // Room Initialization
        Room field = new Room();
        Room lake = new Room();
        Room treeBase = new Room();
        Room treeTop = new Room();
        Room houseBase = new Room();
        Room cellar = new Room();
        Room attic = new Room();

        //field Things

        Thing rustyKey = new Thing("Rusty Key", "A small iron key encrusted with rust.", true);
        Thing poppy = new Thing("Poppy", "A vibrant red-orange poppy.", true);
        Thing lavender = new Thing("Lavender", "Three purple stalks of lavender.", true);
        Thing sunflower = new Thing("Sunflower", "A large head of a yellow sunflower.", true);
        Thing feathers = new Thing("Feather", "Feathers of curiously avian origin. They lead towards the lake.", false);

        ArrayList<Thing> fieldContents = new ArrayList<Thing>();
        fieldContents.add(rustyKey);
        fieldContents.add(poppy);
        fieldContents.add(lavender);
        fieldContents.add(sunflower);
        fieldContents.add(feathers);

        field.init("Field", "You arrive at a clearing in the forest.",
        fieldContents, treeBase, houseBase, lake, null, null, null);

        //lake Things

        Thing foodColor = new Thing("Food coloring", "Food coloring made from crushed flowers.", false);
        Thing stone = new Thing("Stone", "A river rock with a smooth surface.", true);
        Thing bowl = new Thing("Bowl", "A wooden bowl that was floating in the lake.", true);
        // duck in the lake
        Animal duck = new Animal("Duck", "An amicable duck", true, "What a cool duck.", 
                                 "This food coloring could make almost anything look good.");
        

        ArrayList<Thing> lakeContents = new ArrayList<Thing>();
        lakeContents.add(foodColor);
        lakeContents.add(stone);
        lakeContents.add(bowl);
        lakeContents.add(duck);

        lake.init("Lake", "You find a small lake bordering the field. It smells watery.",
                  lakeContents, null, null, null, field, null, null);

        //treeBase Things

        Thing doorBunker = new Thing("Bunker Door", "An imposing steel door. At the top of the door is a sliding eyehole, also plated in steel.", false);
        Thing securityCamera = new Thing("Security Camera", " A mounted camera always pointed at you. It seems like someone is operating it.", true);
        Thing nuts = new Thing("Nuts", "Long lasting nuts given by Squirrel.", false);
        Animal squirrel = new Animal("Squirrel", "Small and prideful. Itching at the chance to show off his project.", 
                                        true, "These nuts have an expiration date 2 centuries from now.", "");

        ArrayList<Thing> treeBaseContents = new ArrayList<Thing>();
        treeBaseContents.add(doorBunker);
        treeBaseContents.add(securityCamera);
        treeBaseContents.add(squirrel);
        treeBaseContents.add(nuts);

        treeBase.init("Tree Base"," In front of you is a massive cedar tree that looms over the entire forest. At the base, you see a bunker set in the tree's massive roots.",
                      treeBaseContents, null, field, null, null, treeTop, null);

        //treeTop Things

        Thing honey = new Thing("Honey", "A very expensive bottle of honey", false);
        Animal bee = new Animal("Bee","A rich and secluded bee", true,"Wow this bee has a lot of money … and judgment.", " This honey the bee gave me is feels like it's worth more than a house.");

        ArrayList<Thing> treeTopContents = new ArrayList<Thing>();
        treeTopContents.add(bee);
        treeTopContents.add(honey);

        treeTop.init("Tree Top", "In the canopy of the tree is a hidden lavishly decorated patio. A sweet smell lingers in the air.",
                     treeTopContents, null, null, null, null, null, treeBase);

        //houseBase Things

        ArrayList<Thing> houseBaseContents = new ArrayList<Thing>();

        houseBase.init("House Base", "Ground floor of the house, the walls are detailed with dark wood paneling.",
                        houseBaseContents, field, null, null, null, attic, cellar);

        //cellar Things
        Thing cheese = new Thing("Cheese", "A generous amount of cheese", false);
        Animal mouse = new Animal("Mouse"," A mouse", true, "A collection of Mice live in the cellar", "I got a very generous amount of cheese from the mouse, too much to eat at once");


        ArrayList<Thing> cellarContents = new ArrayList<Thing>();
        cellarContents.add(cheese);
        cellarContents.add(mouse);


        cellar.init("Cellar", "Storage area for the house. A thin layer of dust coats everything in the room.",
        cellarContents, null, null, null, null, houseBase, null);

        //attic Things

        Thing coffeeBeans = new Thing("Coffee Beans", "Roasted coffee beans meant for eating. Well suited for reading late at night.", true);
        Animal toad = new Animal("Toad", "A Massive toad seated in a similarly sized chair. Currently reading books supernaturally fast, constantly turning pages.", true, "He is reading books all by the same author", "If I ate enough of these coffee beans, I could stay awake forever."); 

        ArrayList<Thing> atticContents = new ArrayList<Thing>();
        atticContents.add(coffeeBeans);
        atticContents.add(toad);


        attic.init("Attic", "A small personal library at the top of the house. Many books are haphazardly strewn about the room.",
                   atticContents, null, null, null, null, null, houseBase);


        player.setLocation(field);
    }

    /**
     * Runs a command given a String, and returns the resulting String.
     * @param input - the command entered by the user
     * @return the result of the command being ran
     */
    public String runCommand(String input) {
        String s = "Thank you for playing!";
        ArrayList<String> inputList;
        input = input.trim().toLowerCase();

        if (!input.equals("q")) {
            if (input.equals("")) {
                s = "Enter a command please.";
            } else {
                inputList = Words.listify(input);
                s = Words.parse(inputList);
            }
        }

        return s;
    }

    /**
     * Gets the player
     * @return the Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Displays the help command.
     * @return help command text
     */
    public String help() {
        String s = "";
        Thing goCommand = new Thing("Go","Go to a connecting location. You can use a direction. \nExample: \n> go north");
        Thing useCommand = new Thing("Use", "Use an item in your inventory. \nExample: \n> use rusty key");
        Thing lookCommand = new Thing("Look", "Look at your surroundings or at a specific object in them. \n Example: \n> look \n>look at shelf");
        Thing helpCommand = new Thing("Help", "Display all commands. \nExample: \n> help");
        Thing invCommand = new Thing("Inventory", "Display your inventory. \nExample: \n> inventory \n> inv");
        ArrayList<Thing> commands = new ArrayList<Thing>();
        commands.add(goCommand);
        commands.add(useCommand);
        commands.add(lookCommand);
        commands.add(helpCommand);
        commands.add(invCommand);
        for (int i = 0; i < commands.size(); i++) {
            s += "+------------------------------------------------------------------------------+\n";
            s += commands.get(i).getName() + "\n" + commands.get(i).getDesc() + "\n";
        }
        s += "+-----------------------------------------------------------------------------+\n";
        return s;
    }

    /**
     * Gets the map.
     * @return the ArrayList<Room> that is the map
     */
    public ArrayList<Room> getMap() {
        return map;
    }

    /**
     * Moves the player in the entered direction (if possible)
     * @param dir - the direction entered by the user
     * @return a String containing a success/failure of movement message.
     */
    public String goDir(String dir) {
        String s = "";
        Room r = null;
        switch (dir) {
            case "north":
                r = player.getLocation().getNorth();
                break;
                    
            case "south":
                r = player.getLocation().getSouth();
                break;

            case "east":
                r = player.getLocation().getEast();
                break;

            case "west":
                r = player.getLocation().getWest();
                break;

            case "up":
                r = player.getLocation().getUp();
                break;

            case "down": 
                r = player.getLocation().getDown();
                break;
        }
        if (!(r == null)) {
            player.setLocation(r);
            s = "You went " + dir.toUpperCase() + " to " + player.getLocation().getName().toUpperCase() + ".";
            s += "\n" + player.getLocation().describe();
        } else {
            s = "There isn't anything to go to to the " + dir.toUpperCase() + ".";
        }
        return s;
    }
}