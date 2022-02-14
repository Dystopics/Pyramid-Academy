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
        System.out.println(displayStory(0));
        int input = -1;
        boolean cSelected = false;
        //loops until a good input is entered
        do {
            do {
                input = getInInt();
            } while (input == -1);

            if(input == 1 || input == 2) {
                System.out.print(displayStory(input));
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
    public static String displayStory(int page)
    {
        switch (page) {
            case 0: {
                //beginning prompt
                return "You are in a land full of dragons. In front of you,\n you see two caves. In one cave, the dragon is friendly\n and will share his treasure with you. The other dragon\n is greedy and hungry and will eat you on sight.\n Which cave will you go into? (1 or 2)";
            }
            case 1: {
                //Option 1 - bad end
                return "You approach the cave...\n It is dark and spooky...\n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!";
            }
            case 2: {
                //Option 2 - less bad end
                return "You approach the cave...\n It is dark and spooky...\n You light a torch to see better...\n The Cave is empty";
            }
        }
        return "Error: Text requested out of bounds";
    }
}
