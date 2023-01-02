package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberChecker {


    public static boolean isEven(int input) {
        String intToString = Integer.toString(input);
        int lastDigit = intToString.charAt(intToString.length()-1);
        return lastDigit % 2 == 0;
    }

    public static boolean isOdd(int input) {
        String intToString = Integer.toString(input);
        int lastDigit = intToString.charAt(intToString.length()-1);
        return lastDigit % 2 != 0;
    }


    public static boolean isBuzz(int input){
        return endsWithSeven(input) || isDivisibleBySeven(input);
    }

    public static boolean endsWithSeven (int input) {
        String intToString = Integer.toString(input);
        int lastDigit = Character.getNumericValue(intToString.charAt(intToString.length()-1));
        return lastDigit ==  7;
    }

    public static boolean isDivisibleBySeven(int input) {
        return input % 7 == 0;
    }

    public static boolean isDuck(int input){
        String inputString = Integer.toString(input);
        boolean isDuck = false;
        for (int i = 1; i < inputString.length(); i++) {
            if (Character.getNumericValue(inputString.charAt(i)) == 0) {
                isDuck = true;
            }
        }
        return isDuck;
    }
}





