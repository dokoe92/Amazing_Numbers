package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {

    Long[] numbers;
    Util util;

    public Display() {
        this.numbers = new Long[2];
        util = new Util();
    }


    public void printConsole() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter two natural numbers to obtain the properties of the list");
        System.out.println(" * the first parameter represents a starting number");
        System.out.println(" * the second parameters shows how many consecutive numbers are to be processed");
        System.out.println("- two natural numbers and a property to search for");
        System.out.println("- separate the parameters with one space");
        System.out.println("- enter 0 to exit");

        while (true) {
            String input = getInput();
            Request request = util.processInput(input);

            switch (request) {
                case EMPTY -> printConsole();
                case INVALID_NUMBER1 -> System.out.println("The first parameter should be a natural number or zero.");
                case ONE_NUMBER -> propertyOf(util.parseToLong(util.inputValues.get(0)));
                case INVALID_NUMBER2 -> System.out.println("The second parameter should be a natural number");
                case TWO_NUMBERS -> propertyOfList(util.parseToLong(util.inputValues.get(0)), util.parseToLong(util.inputValues.get(1)));
                case ZERO -> System.exit(0);


            }
        }
    }

    public String getInput() {
        System.out.println("Enter a request: ");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        String[] stringArr = inputValue.split(" ");
        if (!util.isValidNumber(stringArr[0])) {
            return "";
        } else {
            return inputValue;
        }

    }


    public void propertyOf(Long input) {
        System.out.println("Properties of " + input);
        System.out.println("buzz: " + NumberChecker.isBuzz(input));
        System.out.println("duck: " + NumberChecker.isDuck(input));
        System.out.println("palindromic: " + NumberChecker.isPalindrom(input));
        System.out.println("even: " + NumberChecker.isEven(input));
        System.out.println("odd: " + NumberChecker.isOdd(input));
        System.out.println("gapful: " + NumberChecker.isGapful(input));
    }

    public void propertyOfList(long startNumber, long length) {
        propertyOfListOutput(startNumber);
        for (int i = 1; i < length; i++) {
            long nextNumber = startNumber + i;
            propertyOfListOutput(nextNumber);
        }
    }

    public void propertyOfListOutput(long number) {
        String buzz = NumberChecker.isBuzz(number) ? "buzz" : "";
        String duck = NumberChecker.isDuck(number) ? "duck" : "";
        String palindrom = NumberChecker.isPalindrom(number) ? "palindromic" : "";
        String gapful = NumberChecker.isGapful(number) ? "gapful" : "";
        String even = NumberChecker.isEven(number) ? "even" : "";
        String odd = NumberChecker.isOdd(number) ? "odd" : "";

        System.out.println(number + " is " + buzz + " " + duck + " " + palindrom + " " + gapful + " " + even + " " + odd);

    }


}
