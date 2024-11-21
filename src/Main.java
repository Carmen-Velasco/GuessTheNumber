import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

     int menuchoice = 0;
     int upperlimit = 0;
     int maxattempts = 0;
     Scanner scanner = new Scanner(System.in);

     System.out.println ("Welcome to the Guess the Number Game");

     // loop until the user chooses to exit
        while (menuchoice < 1 || menuchoice > 5){
            // Display the menu options
            System.out.println("===== Pick your difficulty level =====");
            System.out.println("1. Option 1: Easy");
            System.out.println("2. Option 2: Medium");
            System.out.println("3. Option 3: Difficult");
            System.out.println("4. Option 4: Impossible");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            // Get user input
            menuchoice = scanner.nextInt();

            // Perform actions based on the user's choice
            switch (menuchoice){
                case 1: // easy
                    System.out.println("You picked easy level!");
                    upperlimit = 50;
                    maxattempts = 30;
                    break;
                case 2: // medium (also default)
                    System.out.println("You picked medium level!");
                    upperlimit = 100;
                    maxattempts = 20;
                    break;
                case 3: // difficult
                    System.out.println("You picked difficult level!");
                    upperlimit = 250;
                    maxattempts = 10;
                    break;
                case 4: // impossible
                    System.out.println("You picked impossible level!");
                    upperlimit = 1000;
                    maxattempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Please pick again!");
            } // end switch
        } // end while

        // when we get here, we know we have a number between 1 and 5

        // Generate a random number between 1 and 100
        Random r = new Random();
        int numberToGuess = r.nextInt(upperlimit) + 1;
        // System.out.printf("The random number generated was %d. The upper limit was %d\n", numberToGuess, upperlimit);
        boolean win = false;
        int attemptnumber = 0;

        while ( !win && attemptnumber < maxattempts) {
            attemptnumber = attemptnumber + 1; // increment this

            if (attemptnumber == maxattempts)
            {
                System.out.println("CAREFUL! THIS IS YOUR LAST ATTEMPT");
            }
            // Now let's get the input from the user...
            System.out.printf("(Attempt %d of %d), Enter your guess: ", attemptnumber, maxattempts);
            int guess = scanner.nextInt();

            if (guess == numberToGuess) {
                System.out.printf("Good job! You guessed %d and the number was %d\n", guess, numberToGuess);
                win = true;
            }
            else if (guess < numberToGuess) {
                System.out.println("Your guess was too low. Try a higher number");
            } // end if
            else {
                System.out.println("Your guess was too high. Try a lower number");
            } // end if
        } // end while

        if (!win = false)
        {
            System.out.println("Bad luck! You didn't win, im sure you'll win next time");
        }

    } // end program
} // end class