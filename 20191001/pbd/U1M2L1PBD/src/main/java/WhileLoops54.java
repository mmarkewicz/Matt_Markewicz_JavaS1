import java.util.Random;
import java.util.Scanner;

public class WhileLoops54 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean isUserCorrect = false;
        int numGuesses = 0;

        // random number between 1 and 100
        int computerGuess = 1 + rand.nextInt(100);

        System.out.println("I have chosen a number between 1 and 100. Try to guess it.");
        System.out.println("First Guess: ");

        while (!isUserCorrect) {
            int userGuess = scanner.nextInt();
            if (userGuess == computerGuess) {
                numGuesses++;
                isUserCorrect = true;
                System.out.println("Correct!");
                System.out.println("It took you " + numGuesses + " tries.");
            } else if (userGuess != computerGuess && numGuesses < 7){
                numGuesses++;
                System.out.println("That is incorrect, try again.");
                System.out.println("Guess #" + numGuesses);
            } else {
                isUserCorrect = true;
                System.out.println("You are out of guesses. You lose.");
            };
        }

    }
}
