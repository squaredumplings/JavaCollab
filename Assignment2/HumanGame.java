import java.util.*; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Mihnea Buzoiu
 * @id     1923552
 * @author Nicholas Gurgu
 * @id     1952234
 * @data   TODO
 */

public class HumanGame {

    // some useful variable for later
    Scanner sc = new Scanner(System.in);

    void run() {
        
        // initialize random number using input
        System.out.println("Type an arbitrary number");
        long seed = sc.nextLong();
        Random randomGenerator = new Random(seed);
        int number = randomGenerator.nextInt(100);


        // game starts (seven guesses using for)
        System.out.println("Start guessing!");
        int[] guessVector = new int[10];
        int nrOfGuesses = 0;

        for (int i = 1; i <= 7; i++) {
            // reading guess and updating variables
            int guess = sc.nextInt();
            guessVector[i] = guess;
            nrOfGuesses = i;

            // all cases depending on guess (order is important)
            if (guess == number) {
                System.out.println("Good guess! You won.");
                break;
            }

            if (guess < number) {
                System.out.println("higher");
            }

            if (guess > number) {
                System.out.println("lower");
            }

            if (nrOfGuesses == 7) {
                System.out.println("No more guesses, you lost.");
            }
        }


        // printing the table of guesses
        System.out.println(nrOfGuesses + " guesses:");

        for (int i = 1; i <= nrOfGuesses; i++) {
            for (int j = 0; j < 100; j++) {
                // is j the guess
                if (j == guessVector[i]) {
                    System.out.print("X");
                } else {
                    // is j the correct number
                    if (j == number) {
                        System.out.print("|");
                    } else {
                        System.out.print(".");
                    }
                }
            }
            System.out.print("\n");
        }
        
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
