import java.util.Random;

public class RandomNumbers44 {

    public static void main(String[] args) {
        Random rand = new Random();

        // random number between 0 and 6
        int randomInt = rand.nextInt(6);
        int randomLottoOne = rand.nextInt(54) + 1;
        int randomLottoTwo = rand.nextInt(54) + 1;
        int randomLottoThree = rand.nextInt(54) + 1;
        int randomLottoFour = rand.nextInt(54) + 1;
        int randomLottoFive = rand.nextInt(54) + 1;
        int randomLottoSix = rand.nextInt(54) + 1;

        String[] fortunes = {"A beautiful, smart, and loving person will be coming into your life.", "A dubious friend may be an enemy in camouflage.", "A faithful friend is a strong defense.", "A feather in the hand is better than a bird in the air.", "A fresh start will put you on your way.", "A friend asks only for your time not your money."};
        System.out.println("Fortune cookie say: \"" + fortunes[randomInt] + "\" ");
        System.out.println(randomLottoOne + " - " + randomLottoTwo + " - " + randomLottoThree + " - " + randomLottoFour + " - " + randomLottoFive + " - " + randomLottoSix);

    }
}
