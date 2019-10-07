import java.util.Scanner;

public class WhileLoops63C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 3;
        int b = 4;
        int c = 5;
        int turn = 0;
        boolean isGameOver = false;

        System.out.println("Player 1, enter your name: ");
        String playerOneName = scanner.next();

        System.out.println("Player 2, enter your name: ");
        String playerTwoName = scanner.next();

        while(!isGameOver) {
            if (turn == 0 || turn % 2 == 0) {
                System.out.println("A: " + a);
                System.out.println("B: " + b);
                System.out.println("C: " + c);
                System.out.println(playerOneName + ", choose a pile");
                String userOnePile = scanner.next().toUpperCase();
                System.out.println("How many to remove from pile " + userOnePile);
                int userOneQty = Integer.parseInt(scanner.next());
                switch(userOnePile) {
                    case "A":
                        a -= userOneQty;
                        turn++;
                        break;
                    case "B":
                        b -= userOneQty;
                        turn++;
                        break;
                    case "C":
                        c -= userOneQty;
                        turn++;
                        break;
                    default:
                        System.out.println("That is not a valid input");
                        break;
                }
                if (a <= 0 && b <= 0 && c <= 0) {
                    isGameOver = true;
                    System.out.println("Sorry, " + playerOneName + " you lose!");
                }
            } else {
                System.out.println("A: " + a);
                System.out.println("B: " + b);
                System.out.println("C: " + c);
                System.out.println(playerTwoName + ", choose a pile");
                String userTwoPile = scanner.next().toUpperCase();
                System.out.println("How many to remove from pile " + userTwoPile);
                int userTwoQty = scanner.nextInt();
                switch(userTwoPile) {
                    case "A":
                        a -= userTwoQty;
                        turn++;
                        break;
                    case "B":
                        b -= userTwoQty;
                        turn++;
                        break;
                    case "C":
                        c -= userTwoQty;
                        turn++;
                        break;
                    default:
                        System.out.println("That is not a valid input");
                        break;
                }
                if (a <= 0 && b <= 0 && c <= 0) {
                    isGameOver = true;
                    System.out.println("Sorry, " + playerTwoName + " you lose!");
                }
            }
        }
    }
}

