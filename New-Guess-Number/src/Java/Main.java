import java.util.Scanner;
import java.util.Random;

public class Main {

    //setting public variables to be accessible to many methods
    protected static int secretNum; // number to be guessed
    protected static String userName; // users name
    protected static int guessNumber; // how many guesses have been attempted

    public static void main(String[] args) {

        setName();

        do {
            reset();

            System.out.println(genPrompt(1));

            System.out.println(gameLoop());

        } while (playAgain());
    }

    //method handles guess comparisons
    public static boolean guess(int guess) {
        //determines if the users guess matches the secret number
        if (guess > secretNum)
            System.out.println(genPrompt(5));
        else if (guess < secretNum)
            System.out.println(genPrompt(6));
        return secretNum == guess;
    }

    public static String getUserInput() {
        //handles all user input. fails to "-1"
        Scanner input = new Scanner(System.in);
        String data = "-1";
        try {
            data = input.nextLine();
        } catch (Exception e) {
            System.out.println(genPrompt(7));
        }
        return data;
    }
    public static boolean playAgain() {
        //method queries user about playing again, and requires a valid 'y' or 'n'
        do {
            System.out.println(genPrompt(8));
            String userChoice = getUserInput();
            if (userChoice.equalsIgnoreCase("y")) {
                return true;
            } else if (userChoice.equalsIgnoreCase("n"))
                return false;
            else
                System.out.println(genPrompt(9));
        } while (true);
    }

    public static void generateRand() {
        //method to set a new random number between 1 and 20
        Random number = new Random();
        secretNum = number.nextInt(20) + 1;
    }

    public static void setName() {
        //prompts user for name, and loops to catch any weird or invalid inputs
        System.out.println(genPrompt(0));
        do {
            userName = getUserInput();
        } while (userName.equals("-1"));
    }

    public static String genPrompt(int page) {
        //stores all text displayed.
        switch (page) {
            case 0:
                return "Hello! What is your name?";
            case 1:
                return "Well, " + userName + ", I am think of a number between 1 and 20";
            case 2:
                return "Please enter a number between 1 and 20";
            case 3:
                return "Good job, " + userName + "! You guess my number in " + guessNumber + " guesses!";
            case 4:
                return "You lose, " + userName + ". You failed to guess " + secretNum + " in six tries.";
            case 5:
                return "Your guess is too high!";
            case 6:
                return "Your guess is too low!";
            case 7:
                return "That wasn't a valid input, please try again";
            case 8:
                return "Would you like to play again?";
            case 9:
                return "Please enter 'y' or 'n'";
        }
        return "Err 01: text selection out of bounds";
    }

    public static void reset() {
        //resets global variables for the next round
        generateRand();
        guessNumber = 0;
    }

    public static String gameLoop() {
        //main logic loop for game
        int userGuess = 0; // stores users guess while input is validated
        boolean validIn = false; // loop variable, while valid is false, continue loop
        System.out.println(genPrompt(1));
        do {
            while(!validIn) {
                validIn = true; // breaks out of loop if exception is NOT thrown
                try {
                    userGuess = Integer.parseInt(getUserInput());
                } catch (Exception e) {
                    System.out.println(genPrompt(2));
                    validIn = false;
                }
            }
            guessNumber++; // increments global variable
        }
        while (!guess(userGuess) && guessNumber <= 6) ; //breaks loop if you guess correctly or guess 6 times and fail
        {
            if (guessNumber >= 6)
                return genPrompt(4);
            else
                return genPrompt(5);
        }
    }
}
