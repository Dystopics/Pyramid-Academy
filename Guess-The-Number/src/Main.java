import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        String name = new String();

        int secretNum = generator.nextInt(20) + 1;
        int uGuess;
        int guessNum = 0;
        boolean exit = false;
        String playAgain = "y";

        //prompt for name
        System.out.println("Hello! What is your name?");

        name = input.nextLine();

        //do while loop containing input
        //repeat until correct guess
        do{
        //continued prompt
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            do{
                System.out.println("Take a guess.");
                do {
                    try {
                        uGuess = input.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                        exit = false;
                    }
                }while(exit == true);

                    guessNum++;

                    if(uGuess > secretNum)
                        System.out.println("Your guess is too high.");
                    else if(uGuess < secretNum)
                        System.out.println("Your guess is too low.");
                    else {
                        System.out.println("Good job, " + name + "! You guess my number in " + guessNum + " guesses!");
                        System.out.println("Would you like to play again? (y or n)");
                        playAgain = input.next();
                    }

            }while(secretNum != uGuess);
        }while(playAgain.equals("y"));

    }
}
