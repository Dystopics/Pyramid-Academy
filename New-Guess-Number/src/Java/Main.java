import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        String userName;
        Random generator = new Random();
        int secretNum = generator.nextInt(20) + 1;
        int userGuess;
        int guessNumber = 0;
        String guessHolder;
        boolean guessCorrect = false;

        System.out.println("Hello! What is your name?");
        do {
            userName = getUserInput(0);
        } while( userName == null);

        do {

            System.out.println("Well, " + userName + ", I am think of a number between 1 and 20");


            System.out.println(secretNum);

            do {
                guessHolder = getUserInput(1);
                if(guessHolder == null) {
                    System.out.println("Please enter a number between 1 and 20");
                }
                else{
                    userGuess = Integer.parseInt(guessHolder);
                    guessCorrect = guess(userGuess, secretNum);
                    guessNumber++;

                }
            } while (!guessCorrect);
            System.out.println("Good job, " + userName + "! You guess my number in " + guessNumber + " guesses!");
        } while(playAgain());
    }

    //method handles guess comparisons
    public static boolean guess(int guess, int secret){
        if(guess > secret)
            System.out.println("Your guess is too high!");
        else if(guess < secret)
            System.out.println("Your guess is too low!");

        return secret == guess;
    }

    //method handles all user inputs
    public static String getUserInput(int i){
        Scanner input = new Scanner(System.in);
        String data;
        try{
            data = input.nextLine();
        }
        catch(Exception e)
        {
            //catch returns null to indicate failed input
            System.out.println("That wasn't a valid input, please try again");
            return null;
        }
        switch(i){
            case 0:
                //name input
                return data;
            case 1:
                //guess input
                try{
                    Integer.parseInt(data);
                } catch(Exception e){
                    return null;
                }
                return data;
            case 2:
                //play again input
                if(data.equalsIgnoreCase("y") || data.equalsIgnoreCase("n"))
                    return data;
                else
                {
                    System.out.println("Please enter 'y' or 'n'");
                    return null;
                }
        }
        return null;
    }

    //method queries user about playing again, and requires a valid 'y' or 'n'
    public static boolean playAgain(){
        do {
            System.out.println("Would you like to play again?");
            String userChoice = getUserInput(2);
            if(userChoice != null && userChoice.equalsIgnoreCase("y"))
            {
                return true;
            }
            else if(userChoice != null && userChoice.equalsIgnoreCase("n"))
                return false;
        } while(true);
    }
}
