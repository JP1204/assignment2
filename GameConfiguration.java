package assignment2;

/* EE422C Assignment #2 
 * Fall 2017
 */
public class GameConfiguration {
	public static int guessNumber = 12;
	public static String[] colors = {"B","G","O","P","R","Y"};
	public static int pegNumber = 4;

	public static int getPegNumber() {
		return pegNumber;
	}

	public static void setPegNumber(int pegNumber) {
		GameConfiguration.pegNumber = pegNumber;
	}

	public static int getGuessNumber() {
		return guessNumber;
	}

	public static void setGuessNumber(int guessNumber) {
		GameConfiguration.guessNumber = guessNumber;
	}

	public static String[] getColors() {
		return colors;
	}

	public static void setColors(String[] colors) {
		GameConfiguration.colors = colors;
	}
}
