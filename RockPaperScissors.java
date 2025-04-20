import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = { "Rock", "Paper", "Scissors" };

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your choice (Rock, Paper, Scissors or Exit to quit): ");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("Exit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            boolean validChoice = false;
            for (String choice : choices) {
                if (userChoice.equalsIgnoreCase(choice)) {
                    validChoice = true;
                    break;
                }
            }

            if (!validChoice) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];

            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                    (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                    (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }

        scanner.close();
    }
}
