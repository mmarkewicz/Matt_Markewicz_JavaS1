import java.util.Random;

public class RandomNumbers45 {

    public static void main(String[] args) {
        Random rand = new Random();

        int diceOne = rand.nextInt(6) + 1;
        int diceTwo = rand.nextInt(6) + 1;
        int total = diceOne + diceTwo;

        System.out.println("Roll #1: " + diceOne);
        System.out.println("Roll #2: " + diceTwo);
        System.out.println("The total is " + total + "!");
    }

}
