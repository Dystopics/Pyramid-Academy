import java.util.Scanner;
import java.util.Random;

public class Game {

    public void run() {
        // write your code here
        Random generator = new Random();
        String name;

        int secretNum = generator.nextInt(20) + 1;
        int uGuess;
        int guessNum = 0;
        boolean exit = false;
        String playAgain = "y";

        //prompt for name
        System.out.println("Hello! What is your name?");
        do {
            name = getString();
        }while (name.equals(null));

        //do while loop containing input
        //repeat until correct guess
        do {
            playAgain = null; // resets the play again function
            guessNum = 0;

            //continued prompt
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            do {
                System.out.println("Take a guess.");
                uGuess = getGuess();

                guessNum++;
                if (uGuess > secretNum)
                    System.out.println("Your guess is too high.");
                else if (uGuess < secretNum)
                    System.out.println("Your guess is too low.");
                else {
                    System.out.println("Good job, " + name + "! You guess my number in " + guessNum + " guesses!");
                    System.out.println("Would you like to play again? (y or n)");
                    do {
                        playAgain = getString();
                    } while(playAgain == null);
                }
            } while (secretNum != uGuess);
        } while (playAgain.equals("y"));

    }

    public static String getString(){
        Scanner input = new Scanner(System.in);
        String data;
        try{
            data = input.nextLine();
        }
        catch(Exception e)
        {
            //catch returns null to indicate failed input
            System.out.println(e);
            System.out.println("That wasn't a valid input, please try again");
            return null;
        }
        return data;
    }

    public static int getGuess(){
        //method for taking integer input for guesses
        Scanner input = new Scanner(System.in);
        int guess;
        try{
            guess = input.nextInt();
        }
        catch(Exception e)
        {
            //catch returns -1 to indicate failed input
            System.out.println(e);
            System.out.println("That wasn't a valid guess, please try again");
            return -1;
        }
        return guess;

    }
}
