import java.util.Scanner;

public class IfStatements26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your current earth weight: ");
        int userInputWeight = scanner.nextInt();

        System.out.println("I have information for the following planets:");
        System.out.println("1. Venus     2. Mars     3. Jupiter");
        System.out.println("4. Saturn    5. Uranus   6.Neptune");

        System.out.println("");
        System.out.println("Which planet are you visiting?");
        int userInputPlanet = scanner.nextInt();

        switch(userInputPlanet) {
            case 1:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 0.78d) + " on that planet.");
                break;
            case 2:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 0.39d) + " on that planet.");
                break;
            case 3:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 2.65d) + " on that planet.");
                break;
            case 4:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 1.17d) + " on that planet.");
                break;
            case 5:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 1.05d) + " on that planet.");
                break;
            case 6:
                System.out.println("Your weight would be " + (((double)userInputWeight) * 1.23d) + " on that planet.");
                break;
        }

    }

}
