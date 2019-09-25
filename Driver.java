package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) throws FileNotFoundException {
        // configure game
        GameConfiguration.setGuessNumber(12);
        GameConfiguration.setPegNumber(4);
        GameConfiguration.setColors(new String[]{"F", "G", "H", "J", "L", "K"});
        // get testing mode
        boolean testingMode;
        int numOfGuesses = GameConfiguration.getGuessNumber();
        int codeLength = GameConfiguration.getPegNumber();
        Scanner scan = new Scanner(System.in);
        // configure code
        Code.setCode_length(GameConfiguration.getPegNumber());
        Code.setValidColors(GameConfiguration.getColors());

        if(args.length != 1)
           return;
        else if(Integer.parseInt(args[0]) == 1)
            testingMode = true;
        else
            testingMode = false;

        // create game
        Game mastermindGame = new Game(testingMode, numOfGuesses, scan);

        // display greeting
        File greeting = new File(System.getProperty("user.dir") + "/src/assignment2/InitialGreeting.txt");
        Scanner sc = new Scanner(greeting);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        // prompts if the user wants to play the game
        boolean startGame = promptUser(scan);

        // run game
        if(startGame)
            mastermindGame.runGame();
    }


    // returns true if response is valid (History is not valid)
    private static boolean promptUser(Scanner scan) {
        System.out.println("Are you ready to play? (Y/N): ");
        String response = scan.nextLine();

        // check if response if valid
        if(response.length() > 1){
            System.out.println("Invalid Response");
            return promptUser(scan);
        }
        else if(response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            return true;
        else if(response.charAt(0) == 'n' || response.charAt(0) == 'N')
            return false;
        else {
            System.out.println("Invalid Response");
            return promptUser(scan);
        }
    }
}
