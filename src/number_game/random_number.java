package number_game;

import java.util.Scanner;
import java.util.Random;

public class random_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I have selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts == numberOfAttempts) {
                    System.out.println("Out of attempts! The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your score is: " + score);
        scanner.close();
    }
}
