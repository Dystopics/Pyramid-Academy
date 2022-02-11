import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int uInput;
        boolean caveSelected = false;

        //story prompt
        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        //handles numbers outside of 1 and 2
        do {
            uInput = getInput();

            if (uInput == 1) {
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");
                caveSelected = true;
            } else if (uInput == 2) {
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("You light a torch to see better...");
                System.out.println("The Cave is empty");
                caveSelected = true;
            } else
                System.out.println("please enter a 1 or 2");

        } while(caveSelected == false);

    }

    public static int getInput()
    {
        //method to handle input, and to test input
        Scanner input = new Scanner(System.in);
        int result = -1;
        try{
            result = input.nextInt();
        }
        catch(Exception e){
            System.out.println("You did not enter 1 or 2");
        }
        return result;
    }
}

