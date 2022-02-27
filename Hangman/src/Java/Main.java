import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String guesses; // collects all guessed letters
        String word;
        String guess;
        int state = 0;
        boolean again = true;
        boolean gameOver = false;
        //char[] hit;
        //char[] miss = new char[26];
        ArrayList<Character> hit = new ArrayList();
        ArrayList<Character> miss = new ArrayList();

        while(again)
        {
            System.out.println(prompt(2));
            word = getNewWord();//pulls a random word
            guesses = "";
            //hit = new char[word.length()];//sets hit array to length of word
            for(int i = 0; i < word.length(); i++) //sets up hit with placeholder underscores, which get replaced as correct guesses are made
            {
                hit.add('_');
            }

            while(!gameOver) {
                System.out.println(drawBoard(state));//draws the board, state being a visual indicator for number of misses
                System.out.println(displayMisses(miss));
                System.out.println(displayHits(hit));
                System.out.println(prompt(0));//prompts Guess a number
                guess = getGuess();//gets the user input
                if(guess.equals("ERR1"))
                {
                    System.out.println(prompt(-1));
                }
                else if(guess.equals("ERR2")){
                    System.out.println(prompt(4));
                }
                else if(guesses.contains(guess) )//if the guessed letter has already been guessed
                {
                    System.out.println(prompt(1));
                }
                else if(word.contains(guess))//if the guessed letter is in the word
                {
                    for (int i = 0; i < word.length(); i++) //iterates through the secret word, replacing underscores with the guessed letter
                    {
                        if (word.charAt(i) == guess.charAt(0)) {
                            hit.remove(i);
                            hit.add(i,guess.charAt(0));
                        }
                    }
                }
                else if(state>3)
                    gameOver = true;
                else
                {
                    miss.add(guess.charAt(0));
                    state++;
                }
                if(word.equals(hit.toString()))
                {
                    System.out.println(prompt(word));
                    gameOver = true;
                }
            }
            do {
                System.out.println(prompt(3));
                guess = getGuess();
            }while(!guess.equalsIgnoreCase("y") && !guess.equalsIgnoreCase("n"));
            again = guess.equalsIgnoreCase("y");
        }
    }

    public static String drawBoard(int state){
        switch(state) {
            case 0:
                return "+---+\n    |\n    |\n    |\n   ===";
            case 1:
                return "+---+\nO   |\n    |\n    |\n   ===";
            case 2:
                return "+---+\nO   |\n|   |\n    |\n   ===";
            case 3:
                return "+---+\nO   |\n|   |\n|   |\n   ===";
        }
        return "Game Over";
    }

    public static String getNewWord(){
        FileInputStream fileSource;
        Scanner input;
        String selection = "";

        try {
            fileSource = new FileInputStream("src/Java/words.csv");//csv file containing one int and a list of words. int should be total number of csv tokens
        }catch(Exception e){
            return e.toString();
        }

        input = new Scanner(fileSource);
        input.useDelimiter(","); //separate tokens by commas

        for(int i = generateRand(input.nextInt()); i > 0; i--)//loop should generate a random number within hte bounds of the word list, and iterate through to that index
        {
            selection = input.next();
        }
        return selection;
    }

    public static String prompt(int page){
        switch(page){
            case 0:
                return "Guess a Letter";
            case 1:
                return "You already guessed that letter";
            case 2:
                return "H A N G M A N";
            case 3:
                return "Would you like to play again? (yes or no)";
            case 4:
                return "Your guess should be only one letter";
        }
        return "ERROR: PROMPT OOB";
    }
    public static String prompt(String word){
        return "Yes! The secret word is \"" + word + "\"! You Have Won!";
    }

    public static int generateRand(int limit) {
        //method to set a new random number between 1 and the input number
        Random number = new Random();
        return number.nextInt(limit);
    }

    public static String getGuess(){
        //takes input, validates it, and deCases it
        String guess;
        Scanner input = new Scanner(System.in);
        try {
            guess = input.nextLine();
        }catch(Exception e) {
            return "ERR1";
        }

        if(guess.length() != 1)
            return "ERR2";

        return guess.toLowerCase();

    }

    public static String displayMisses(ArrayList<Character> misses){
        String result = "";
        for(Character number: misses){
            result = result.concat(String.valueOf(number));
        }
        return "Missed Letters: " + result + "\n";
    }

    public static String displayHits(ArrayList<Character> hits){
        String result = "";
        for (Character hit : hits) {
            result = result.concat(String.valueOf(hit) + " ");
        }
        return result;
    }
}
