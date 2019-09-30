import java.util.Random;
import java.util.Scanner;

public class WhileLoops53 {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean isUserCorrect = false;
        int numGuesses = 0;

        // random number between 1 and 10
        int computerGuess = 1 + rand.nextInt(10);

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        while (!isUserCorrect) {
            int userGuess = scanner.nextInt();
            if (userGuess == computerGuess) {
                numGuesses++;
                isUserCorrect = true;
                System.out.println("Correct!");
                System.out.println("It took you " + numGuesses + " tries.");
            } else {
                numGuesses++;
                System.out.println("That is incorrect, try again.");
            };
        }

    }
}
