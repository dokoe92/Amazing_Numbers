package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        write your code here
        console();
    }

    public static void console() {
        int input = 0;
        try {
            System.out.println("Enter a natural number: ");
            input = new Scanner(System.in).nextInt();
            if (input < 1) {
                System.out.println("This number is not natural!");
            }
        } catch (InputMismatchException e) {
            System.out.println("not a number!");
        }
        System.out.println("Properties of " + input);
        System.out.println("even: " + NumberChecker.isEven(input));
        System.out.println("odd: " + NumberChecker.isOdd(input));
        System.out.println("buzz: " + NumberChecker.isBuzz(input));
        System.out.println("duck: " + NumberChecker.isDuck(input));


    }
}








    /*
    public static void checkIfBuzz() {
        int input = 0;
        try {
            System.out.println("Enter a natural number: ");
            input = new Scanner(System.in).nextInt();
            if (input > 0) {
            } else {
                System.out.println("This number is not natural!");
            }
        } catch (InputMismatchException e) {
            System.out.println("not a number!");
        }
        System.out.println(isEven(input) ? "This number is Even." : "This number is Odd.");
        System.out.println((endsWithSeven(input) || isDivisibleBySeven(input)) ? "It is a Buzz number." : "It is not a Buzz number");
        explainBuzz(input);

    }


    public static boolean isEven(int input) {
        String intToString = Integer.toString(input);
        int lastDigit = intToString.charAt(intToString.length()-1);
        return lastDigit % 2 == 0;
    }

    public static boolean endsWithSeven (int input) {
        String intToString = Integer.toString(input);
        int lastDigit = Character.getNumericValue(intToString.charAt(intToString.length()-1));
        return lastDigit ==  7;
    }

    public static boolean isDivisibleBySeven(int input) {
        return input % 7 == 0;
    }

    public static void explainBuzz(int input) {
        System.out.println("Explanation: ");
        if (endsWithSeven(input) && isDivisibleBySeven(input)) {
            System.out.println(input + " is divisible by 7 and ends with 7");
        } else if (endsWithSeven(input)) {
            System.out.println(input + " ends with 7");
        } else if (isDivisibleBySeven(input)) {
            System.out.println(input + " is divisible by 7");
        } else {
            System.out.println(input + " is neither divisible by 7 nor does it end with 7");
        }
    }*/





