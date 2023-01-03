package numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    Long[] numbers;

    public Console() {
        this.numbers = new Long[2];
    }



    public void printConsole() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter two natural numbers to obtain the properties of the list");
        System.out.println(" * the first parameter represents a starting number");
        System.out.println(" * the second parameters shows how many consecutive numbers are to be processed");
        System.out.println("- separate the parameters with one space");
        System.out.println("- enter 0 to exit");
        while(true) {
            System.out.println("Enter a request: ");
            try {
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();
                String[] splitString = inputString.split("\\s+");
                 for (int i = 0; i < splitString.length; i++) {
                    numbers[i] = Long.parseLong(splitString[i]);
                }

                if (numbers[1] == null) {
                    if (numbers[0] == 0) {
                        System.out.println("GoodBye!");
                        System.exit(0);
                    } else if (numbers[0] < 1) {
                        System.out.println("The first parameter should be a natural number or zero.");
                    } else {
                            singleInput();
                    }
                }
                else {
                    if (numbers[1] < 1) {
                        System.out.println("The second parameter should be a natural number");
                    } else {
                        doubleInput();
                    }
                    numbers[1] = null;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }

    }

    public void singleInput() {
        long input = this.numbers[0];
        System.out.println("Properties of " + input);
        System.out.println("buzz: " + NumberChecker.isBuzz(input));
        System.out.println("duck: " + NumberChecker.isDuck(input));
        System.out.println("palindromic: " + NumberChecker.isPalindrom(input));
        System.out.println("even: " + NumberChecker.isEven(input));
        System.out.println("odd: " + NumberChecker.isOdd(input));
        System.out.println("gapful: " + NumberChecker.isGapful(input));
    }

    public void doubleInput() {
        long length = this.numbers[1];
        long startNumber = this.numbers[0];
        doubleInputOutputText(startNumber);
        for (int i = 1; i < length; i++) {
            long nextNumber = startNumber + i;
            doubleInputOutputText(nextNumber);
        }
    }

    public void doubleInputOutputText(long number) {
        String buzz = NumberChecker.isBuzz(number) ? "buzz" : "";
        String duck = NumberChecker.isDuck(number) ? "duck" : "";
        String palindrom = NumberChecker.isPalindrom(number) ? "palindromic" : "";
        String gapful = NumberChecker.isGapful(number) ? "gapful" : "";
        String even = NumberChecker.isEven(number) ? "even" : "";
        String odd = NumberChecker.isOdd(number) ? "odd" : "";


        System.out.println(number + " is " + buzz + " " + duck + " " + palindrom + " " + gapful + " " + even + " " + odd);

    }





}
