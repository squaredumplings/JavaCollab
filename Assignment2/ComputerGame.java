import java.util.Scanner;

/**
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher" 
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * 
 * @author Mihnea Buzoiu
 * @id     1923552
 * @author Nicholas Gurgu
 * @id     1952234
 * @data   TODO
 */


public class ComputerGame {
    Scanner sc = new Scanner(System.in);

    void run() {
        // printing the initial text (too many characters for one line)
        System.out.println("Think of a secret number not ");
        System.out.println("smaller than 0 and not greater than 999. ");
        System.out.println("Type `go` when you have one.");

        //initializing variables
        int min = 0;
        int max = 999;
        String userInput;

        userInput = sc.next();

        // checks for go
        if (userInput.equals("go")) {
            System.out.println((max - ((max - min) / 2)));

            // if it didn't guess then adjust depending on input
            userInput = sc.next();
            while (!userInput.equals("guessed")) {

                if (userInput.equals("higher")) {
                    min = (max - ((max - min) / 2));
                } else {
                    max = (max - ((max - min) / 2));
                }
                // the new guess
                System.out.println(max - (max - min) / 2);

                userInput = sc.next();
            }
        }
    }

    public static void main(String[] args) {
        new ComputerGame().run();
    }
}
