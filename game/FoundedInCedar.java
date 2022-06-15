package game;

import java.util.Scanner;

/**
* <h1> Founded In Cedar </h1>
* AP CS A Final Project
* Runs our game, Founded In Cedar. :)
* @author Kate Brooks
* @author Blake Chandler
* @since 5-16-22
*/
public class FoundedInCedar {
    static Game game;
    static String name;

    /**
     * Starts the game and keeps it running.
     * @param args
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        game = new Game();
        String input;
        String output;
        game.intro();

        do {
            System.out.print("> ");
            input = console.nextLine();
            output = game.runCommand(input);
            if (!output.trim().isEmpty()) {
                System.out.println(output);
                System.out.println();
            }
        } while (!input.equals("q"));

        console.close();
    }
}