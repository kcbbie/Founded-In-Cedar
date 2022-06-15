package game;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import globals.*;

/**
 * Contains all the word-related things, like parsing, processing, and initializing all the recognizable vocabulary.
 */
public class Words {
    private static HashMap<String, WordType> vocabulary = new HashMap<>();
    public static final int MAX_LINE_LENGTH = 50; // for wrapping the text

    /**
     * Adds all the vocab the program can recognize to the vocabulary HashMap<String, WordType>.
     */
    public static void initVocab() {
        String[] verbs = {"go", "take", "use", "help", "inventory", "inv", "look"};
        String[] nouns = {"rusty key", "rusty", "key", "poppy", "lavender", "sunflower", "sunflowers", 
                          "feathers", "feather", "field", "lake", "tree base", "stone", "bowl", "duck", "bee", "nuts", 
                          "squirrel", "stone", "bowl", "frog", "toad"};
        String[] directions = {"north", "south", "east", "west", "up", "down"};
        String[] prepositions = {"at", "toward", "towards", "to"};
        String[] articles = {"the", "a", "an"};

        for (String v : verbs) {
            vocabulary.put(v, WordType.VERB);
        }
        for (String n : nouns) {
            vocabulary.put(n, WordType.NOUN);
        }
        for (String d : directions) {
            vocabulary.put(d, WordType.DIRECTION);
        }
        for (String p : prepositions) {
            vocabulary.put(p, WordType.PREPOSITION);
        }
        for (String a : articles) {
            vocabulary.put(a, WordType.ARTICLE);
        }
    }

    /**
     * Turns a given String into an ArrayList<String> of words.
     * @param input - the String to be turned into a list
     * @return the ArrayList<String>
     */
    public static ArrayList<String> listify(String input) {
        String delims = "[ \t,.:;?!\"']+";
        ArrayList<String> list = new ArrayList<>();
        String[] words = input.split(delims);

        for(String w : words) {
            list.add(w);
        }

        return list;
    }

    /**
     * Parses an ArrayList<String> and either recognizes every word and processes the command +
     * returns a confirmation String, or gives an error message String.
     * @param inputList - the list of words to parse
     * @return the String that comes from running the relevant command
     */
    public static String parse(ArrayList<String> inputList) {
        HashMap<String, WordType> command = new HashMap<String, WordType>();
        String message = "";
        String errorMessage = "";
        WordType type;

        for (String s : inputList) {
            if (vocabulary.containsKey(s)) {
                type = vocabulary.get(s);
                if (!(type == WordType.ARTICLE)) {
                    command.put(s, type);
                }
            } else {
                errorMessage = "Sorry, " + s + " isn't recognized.";
            }
        }

        if (!errorMessage.isEmpty()) {
            message = errorMessage;
        } else {
            message = process(command);
        }

        return message;
    }

    /**
     * Breaks down a given HashMap and gives back an error or confirmation if the command
     * went through.
     * @param command - the set of keys+values being broken down
     * @return the String that comes from running the relevant command
     */
    public static String process(HashMap<String, WordType> command) {
        String verb = "";
        Map<String, WordType> mappedCommand = command;
        Iterator<String> iterator = mappedCommand.keySet().iterator();

        while(iterator.hasNext()) {
            String key = iterator.next();
            WordType wt = command.get(key);
            if (wt == WordType.PREPOSITION || wt == WordType.ARTICLE) {
                iterator.remove();
            }
            if (wt == WordType.VERB) {
                verb = key;
                iterator.remove();
            }
        }
        String s = "";

        if ((command.size() == 0 || verb.equals("")) && !(verb.equals("inventory") || verb.equals("inv") || verb.equals("help"))) {
            System.out.println("You must enter a command.");
        } else if (command.size() > 4) {
            System.out.println("That command is too long! Please enter a shorter command");
        } else {
            String str = "";
            for (String string : command.keySet()) {
                str += string + " ";
            }
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);
            }

            switch (verb) {
                case "take":
                    s = FoundedInCedar.game.getPlayer().take(str);
                    break;

                //case "use":

                case "look":
                    s = FoundedInCedar.game.getPlayer().look(str);
                    break;

                case "go": 
                    if (str.equals("north") || str.equals("south") || str.equals("east") || str.equals("west") || str.equals("up") || str.equals("down")) {
                        s = FoundedInCedar.game.goDir(str);
                    }
                    break;

                /* 
                case "inv":
                case "inventory":

                */
                case "help":
                    s = FoundedInCedar.game.help();
                    break;
                
                default:
                    System.out.println(verb + " not implemented.");
            }
        }

        return s;
    }

    /**
     * Wraps a given String into multiple lines, where the maximum line length is the class
     * constant MAX_LINE_LENGTH.
     * @param input - the String to be wrapped
     * @return the wrapped String
     */
    public static String textWrapper(String input) {
        String returnStr = "";
        if (input.length() >= MAX_LINE_LENGTH) {
            String temp = "";
            for (int i = 0; i < input.length() / 50 + 1; i++) {
                if (input.length() > MAX_LINE_LENGTH) {
                    temp = input.substring(0, 51);
                    returnStr += temp + "\n";
                    input = input.substring(51);
                } else {
                    returnStr += input.substring(0);
                    break;
                }
            }
        }
        return returnStr;
    }

    // GETTER/SETTER METHODS

    /**
     * Gets the vocabulary HashMap.
     * @return the vocab HashMap<String, WordType>
     */
    public static HashMap<String, WordType> getVocabulary() {
        return vocabulary;
    }
}