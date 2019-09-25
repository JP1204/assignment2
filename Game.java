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
            int code_length = GameConfiguration.getPegNumber();

            // display secret code if testingMode is true
            if(testingMode)
                System.out.printf("The secret code is %s\n\n", secretCode.getCode());

            // initialize history log
            History history = new History();
            int roundCount = 0;     // tracks number of guesses
            // runs game until guess is correct or all guesses are used up
            while(roundCount < numOfGuesses) {
                // prompts the user for guess
                promptGuess(roundCount);
                Code guessCode = new Code(scan.nextLine());

                // check if code is valid
                while (!guessCode.isValidCode()) {
                    // display history if asked by player
                    if (guessCode.getCode().equals("HISTORY"))
                        history.displayHistory();
                    else
                        System.out.println("\nInvalid Guess!"); // exception to Invalid Guess

                    promptGuess(roundCount);
                    // get new guess and check again
                    String newGuess = scan.nextLine();
                    guessCode.setCode_str(newGuess);
                }

                // generate pegs for the given guess code
                PegBoard pegBoard = new PegBoard();
                String resultPegs = pegBoard.findPegs(secretCode, guessCode);
                System.out.println(resultPegs + "\n");

                // log entry into history
                history.logEntry(guessCode, pegBoard);

                // increment round counter and check if game is over
                roundCount++;
                if(pegBoard.getNumOfBlackPegs() == code_length){
                    // all colors and positions were correct
                    System.out.println("Congratulations, you win!");
                    break;
                }
                else if(roundCount == numOfGuesses){
                    System.out.println("Sorry, you are out of guesses. You lose, boo-hoo");
                }
            }

            // prompts player to play another game
            gameOver = !(promptAnotherGame(scan));
        }
    }


    private void promptGuess(int roundCount){
        System.out.printf("You have %d guesses left.\nWhat is your next guess?\n" +
                "Type in the characters for your guess and press enter.\nEnter Guess: ", numOfGuesses-roundCount);
    }


    // returns true if user want to play another game
    private static boolean promptAnotherGame(Scanner scan) {
        System.out.println("Are you ready for another game? (Y/N): ");
        String response = scan.nextLine();

        // check if response if valid
        if(response.length() > 1){
            System.out.println("Invalid Response");
            return promptAnotherGame(scan);
        }
        else if(response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            return true;
        else if(response.charAt(0) == 'n' || response.charAt(0) == 'N')
            return false;
        else {
            System.out.println("Invalid Response");
            return promptAnotherGame(scan);
        }
    }
}
