import java.util.Scanner;

public class IfStatements27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        System.out.println("Q1) How many World Series titles do the Yankees have?");
        System.out.println("    1) 8");
        System.out.println("    2) 27");
        System.out.println("    3) 18");
        int userAnswer1 = scanner.nextInt();

        if (userAnswer1 == 2) {
            correctAnswers++;
            System.out.println("Correct!");
        } else {
            incorrectAnswers++;
            System.out.println("Wrong!");
        }

        System.out.println("Q2) Which pitcher has the most wins in MLB histroy??");
        System.out.println("    1) Cy Young");
        System.out.println("    2) Kurt Schilling");
        System.out.println("    3) Randy Johnson");
        int userAnswer2 = scanner.nextInt();

        if (userAnswer2 == 1) {
            correctAnswers++;
            System.out.println("Correct!");
        } else {
            incorrectAnswers++;
            System.out.println("Wrong!");
        }

        System.out.println("Q3) Who has the most home runs in history?");
        System.out.println("    1) Barry Bonds");
        System.out.println("    2) Alex Rodriguez");
        System.out.println("    3) Derek Jeter");
        int userAnswer3 = scanner.nextInt();

        if (userAnswer2 == 3) {
            correctAnswers++;
            System.out.println("Correct!");
        } else {
            incorrectAnswers++;
            System.out.println("Wrong!");
        }

        System.out.println("You finished with...");
        System.out.println("Wins: " + correctAnswers);
        System.out.println("Losses: " + incorrectAnswers);
    }
}
