package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public int printConsole() {
        System.out.println("Welcome to Amazing Numbers!");
        long input = 0;
        boolean isNaN = true;
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter 0 to exit");
        while(true) {
            System.out.println("Enter a request: ");
            try {
                input = new Scanner(System.in).nextLong();
                if (input == 0) {
                    System.out.println("GoodBye!");
                    System.exit(0);
                } else if (input < 1 ) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else {
                    printProperties(input);
                }
            } catch (InputMismatchException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }

    }

    public void printProperties(long input) {
        System.out.println("Properties of " + input);
        System.out.println("even: " + NumberChecker.isEven(input));
        System.out.println("odd: " + NumberChecker.isOdd(input));
        System.out.println("buzz: " + NumberChecker.isBuzz(input));
        System.out.println("duck: " + NumberChecker.isDuck(input));
        System.out.println("palindromic: " + NumberChecker.isPalindrom(input));
    }



}
