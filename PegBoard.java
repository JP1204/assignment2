package assignment2;

public class PegBoard {
    // create a PegBoard every round to show result
    private int numOfBlackPegs;
    private int numOfWhitePegs;

    // Constructor
    PegBoard(){
        numOfBlackPegs = 0;
        numOfWhitePegs = 0;
    }

    public int getNumOfBlackPegs() {
        return numOfBlackPegs;
    }

    public int getNumOfWhitePegs() {
        return numOfWhitePegs;
    }

    // finds and sets pegs
    public String findPegs(Code secretCode, Code guessCode){
        StringBuilder secret_sb = new StringBuilder(secretCode.getCode());
        StringBuilder guess_sb = new StringBuilder(guessCode.getCode());

        // System.out.println("Secret length: " + secret_sb.length() + " Secret string: " + guessCode.getCode());
        // System.out.println("Guess length: " + guess_sb.length() + " Guess string: " + guessCode.getCode());

        // first find number of black pegs
        for(int i = 0; i < secret_sb.length(); i++){
            System.out.println("index : " + i + "\nsecret[i] = " + secret_sb.charAt(i) + " guess[i] = " + guess_sb.charAt(i));
            if(secret_sb.charAt(i) == guess_sb.charAt(i)){
                numOfBlackPegs++;
                // delete both char from strings to prevent reusing pegs
                secret_sb.deleteCharAt(i);
                guess_sb.deleteCharAt(i);
                i--;    // deletion shifts all the characters down
            }
        }

        // System.out.println("Secret length: " + secret_sb.length() + " Secret string: " + secret_sb.toString());
        // System.out.println("Guess length: " + guess_sb.length() + " Guess string: " + guess_sb.toString());


        // find number of white pegs
        for(int i = 0; i < secret_sb.length(); i++){
            for(int j = 0; j < secret_sb.length(); j++){
                if(secret_sb.charAt(i) == guess_sb.charAt(j)){
                    numOfWhitePegs++;
                    guess_sb.replace(j, j+1, "_");    // replace char to prevent reusing pegs
                    // System.out.println(guess_sb.toString());
                }
            }
        }

        if(numOfBlackPegs == 0 && numOfWhitePegs == 0)
            return "Result: No pegs";
        String resultPegs = String.format("Results: %d black pegs and %d white pegs", numOfBlackPegs, numOfWhitePegs);
        return resultPegs;
    }



}
