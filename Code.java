package assignment2;

public class Code {
    private String code_str;
    private static int code_length;
    private static String[] validColors;

    // Constructor
    public Code(String code) {
        this.code_str = code.toUpperCase();     // convert to upper case for easy testing
    }


    // Getters & Setters
    public String getCode() {
        return code_str;
    }
    public static int getCode_length() {
        return code_length;
    }
    public void setCode_str(String code_str) {
        this.code_str = code_str.toUpperCase();
    }
    public static void setCode_length(int code_length) {
        Code.code_length = code_length;
    }
    public static void setValidColors(String[] validColors) {
        Code.validColors = validColors;
    }

    // check if code is valid
    public boolean isValidCode(){
        if(code_str.length() != code_length){
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
        for(String color : validColors){
            if(color.charAt(0) == target){
                return true;
            }
        }
        return false;
    }

    private void addColor(char color){
        // sdjoigjsdlkgnlskdjglsd
    }
}
