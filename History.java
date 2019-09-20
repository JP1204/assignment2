package assignment2;

import java.util.ArrayList;

public class History {
    private ArrayList<String> entries;

    // Constructor
    History(){
        entries = new ArrayList<>();
    }


    // log entry
    public void logEntry(Code guessCode, PegBoard PB){
        // format string to include guess and number of black/white pegs
        String entry = String.format("%s %dB_%dW", guessCode.getCode(), PB.getNumOfBlackPegs(), PB.getNumOfWhitePegs());
        entries.add(entry);
    }

    // display history
    public void displayHistory(){
        System.out.println("History of Current Game");
        for(int i = 0; i < entries.size(); i++){
            System.out.println(entries.get(i));
        }
        System.out.println();
    }
}
