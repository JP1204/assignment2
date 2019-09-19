package assignment2;

public class Code {
    private String code_str;
    private final static char[] validColors = {'B', 'G', 'O', 'P', 'R', 'Y'};

    // Constructor
    public Code(String code) {
        this.code_str = code.toUpperCase();     // convert to upper case for easy testing
    }

    // Getters
    public String getCode() {
        return code_str;
    }

    public void setCode_str(String code_str) {
        this.code_str = code_str;
    }


    // check if code is valid
    public boolean isValidCode(){
        if(code_str.length() > 4){
            return false;
        }

        for(int i = 0; i < code_str.length(); i++){
            if(!isValidColor(code_str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private boolean isValidColor(char target){
        // check if color is in color array
        for(char color : validColors){
            if(color == target){
                return true;
            }
        }
        return false;
    }
}
