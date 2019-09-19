package assignment2;

import java.util.Scanner;

public class Game {
    private boolean testingMode;
    private int numOfGuesses;
    private Scanner scan;
    // Constructors
    Game(){
        this.testingMode = true;
        this.numOfGuesses = 12;
        this.scan = new Scanner(System.in);
    }
    Game(boolean testingMode, int numOfGuesses, Scanner scan){
        this.testingMode = testingMode;
        this.numOfGuesses = numOfGuesses;
        this.scan = scan;
    }


    public void runGame(){
        boolean gameOver = false;

        while(!gameOver){
            // generate code
            System.out.println("Generating secret code ...");
            Code secretCode = new Code(SecretCodeGenerator.getInstance().getNewSecretCode());
            // display secret code if testingMode is true
            if(testingMode)
                System.out.printf("The secret code is %s\n", secretCode.getCode());

            int roundCount = 0;     // tracks number of guesses
            // prompts the user for guess
            promptGuess(roundCount);
            Code guessCode = new Code(scan.nextLine());

            // check if code is valid
            while(!guessCode.isValidCode()){
                System.out.println("\nInvalid Guess!");
                promptGuess(roundCount);

                // get new guess and check again
                String newGuess = scan.nextLine();
                guessCode.setCode_str(newGuess);
            }

            // generate pegs for the given guess code



            // check if game is over
            gameOver = true;
        }
    }


    public void promptGuess(int roundCount){
        System.out.printf("You have %d guesses left.\nWhat is your next guess?\n" +
                "Type in the characters for your guess and press enter.\nEnter Guess: ", numOfGuesses-roundCount);
    }
}
