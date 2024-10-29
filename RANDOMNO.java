import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int attempts = 0;
            boolean correctGuess = false;
            int randomNumber = generateRandomNumber(1, 100);
            System.out.println("\nNew round! Guess a number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    correctGuess = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Out of attempts! The correct number was: " + randomNumber);
            }

            roundsPlayed++;
            System.out.println("Current score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Final score: " + totalScore);
        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
