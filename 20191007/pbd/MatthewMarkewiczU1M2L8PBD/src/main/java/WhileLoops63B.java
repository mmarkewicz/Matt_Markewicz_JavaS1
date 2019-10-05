import java.util.Scanner;

public class WhileLoops63B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 3;
        int b = 3;
        int c = 3;

        while (a > 0 || b > 0 || c > 0) {
            System.out.println("A: " + a + "   B:" + b + "   C:" + c);
            System.out.println("Choose a pile");
            String userPile = scanner.next().toUpperCase();
            System.out.println("How many to remove from pile " + userPile + ":");
            int userInt = scanner.nextInt();

            switch(userPile) {
                case "A":
                    a -= userInt;
                    break;
                case "B":
                    b -= userInt;
                    break;
                case "C":
                    c -= userInt;
                    break;
                default:
                    System.out.println("That is not a valid selection");
                    break;
            }
        }

        System.out.println("All piles are empty. Good job!");

    }
}
