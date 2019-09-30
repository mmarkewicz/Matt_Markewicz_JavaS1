import java.util.Random;
import java.util.Scanner;

public class RandomNumbers43 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // random number between 1 and 10
        int computerGuess = 1 + rand.nextInt(10);

        System.out.println("Guess a number between 1 and 10");
        int userGuess = scanner.nextInt();

        if (userGuess == computerGuess) {
            System.out.println("That's right! My secret number was " + computerGuess + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + computerGuess + ".");
        }
    }

}
