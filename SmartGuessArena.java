/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Random;
import java.util.Scanner;

class SmartGuessArena {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_TRIES = 7;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("====================================");
        System.out.println("      WELCOME TO NUMBER QUEST");
        System.out.println("====================================");

        while (playAgain) {

            int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_TRIES;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the hidden number between " + MIN + " and " + MAX);
            System.out.println("You have only " + MAX_TRIES + " attempts.");

            while (attemptsLeft > 0) {

                System.out.print("\nEnter your guess: ");
                int userGuess;

                // Input validation
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    input.next();
                    continue;
                }

                userGuess = input.nextInt();

                if (userGuess < MIN || userGuess > MAX) {
                    System.out.println("Please enter a number within the range!");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == secretNumber) {

                    guessedCorrectly = true;
                    roundsWon++;

                    int roundScore = (attemptsLeft + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("\nCorrect! You unlocked the secret number.");
                    System.out.println("Attempts used : " + (MAX_TRIES - attemptsLeft));
                    System.out.println("Round Score   : " + roundScore);

                    break;

                } else if (userGuess > secretNumber) {

                    System.out.println("Too High! Try a smaller number.");

                } else {

                    System.out.println("Too Low! Try a bigger number.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Remaining Attempts: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The hidden number was: " + secretNumber);
            }

            System.out.println("\n========= SCORE BOARD =========");
            System.out.println("Rounds Won : " + roundsWon);
            System.out.println("Total Score: " + totalScore);
            System.out.println("================================");

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = input.next();

            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing Number Quest!");
        input.close();
    }
}