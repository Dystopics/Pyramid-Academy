/*
Project: Dragon Cave
Week 1 - make it work
Week 2 - add try/catch around inputs
Week 3 - add unit testing
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //display first prompt
        displayStory(0);
        int input = -1;
        boolean cSelected = false;
        //loops until a good input is entered
        do {
            do {
                input = getInInt();
            } while (input == -1);

            if(input == 1 || input == 2) {
                displayStory(input);
                cSelected = true;
            }
            else
                System.out.println("Please choose 1 or 2");

        } while(!cSelected);
    }

    //User input - wrapped in a method to make exception handling easier
    public static int getInInt() {
        Scanner input = new Scanner(System.in);
        int result = -1;
        try {
            result = input.nextInt();
        } catch (Exception e) {
            System.out.println("You have to choose 1 or 2");
        }
        return result;
    }

    //all of the static text is called from here
    public static void displayStory(int page)
    {
        switch (page) {
            case 0: {
                //beginning prompt
                System.out.println("You are in a land full of dragons. In front of you,");
                System.out.println("you see two caves. In one cave, the dragon is friendly");
                System.out.println("and will share his treasure with you. The other dragon");
                System.out.println("is greedy and hungry and will eat you on sight.");
                System.out.println("Which cave will you go into? (1 or 2)");
                break;
            }
            case 1: {
                //Option 1 - bad end
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");
                break;
            }
            case 2: {
                //Option 2 - less bad end
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("You light a torch to see better...");
                System.out.println("The Cave is empty");
                break;
            }
        }
    }
}
