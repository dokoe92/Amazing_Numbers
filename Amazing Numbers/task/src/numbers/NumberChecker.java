package numbers;

import java.util.ArrayList;

public class NumberChecker {


    public static boolean isEven(long input) {
        String intToString = Long.toString(input);
        int lastDigit = intToString.charAt(intToString.length()-1);
        return lastDigit % 2 == 0;
    }

    public static boolean isOdd(long input) {
        String intToString = Long.toString(input);
        int lastDigit = intToString.charAt(intToString.length()-1);
        return lastDigit % 2 != 0;
    }


    public static boolean isBuzz(long input){
        return endsWithSeven(input) || isDivisibleBySeven(input);
    }

    public static boolean endsWithSeven (long input) {
        String intToString = Long.toString(input);
        int lastDigit = Character.getNumericValue(intToString.charAt(intToString.length()-1));
        return lastDigit ==  7;
    }

    public static boolean isDivisibleBySeven(long input) {
        return input % 7 == 0;
    }

    public static boolean isDuck(long input){
        String inputString = Long.toString(input);
        boolean isDuck = false;
        for (int i = 1; i < inputString.length(); i++) {
            if (Character.getNumericValue(inputString.charAt(i)) == 0) {
                isDuck = true;
            }
        }
        return isDuck;
    }

    public static boolean isPalindrom(long input) {
        String numberAsString = Long.toString(input);
        StringBuilder reverseNumber = new StringBuilder(numberAsString).reverse();
        return numberAsString.contentEquals(reverseNumber);
    }

    public static boolean isGapful(long input) {
        String inputToString = Long.toString(input);
        if (inputToString.length() >= 3) {
            int firstDigit = Character.getNumericValue(inputToString.charAt(0));
            int lastDigit = Character.getNumericValue(inputToString.charAt(inputToString.length()-1));
            String divisorSTring = Integer.toString(firstDigit) + Integer.toString(lastDigit);
            int divisor = Integer.parseInt(divisorSTring);
            return input % divisor == 0;
        }
        return false;
    }

    public static boolean isSpy(long input) {
        long sum = 0;
        long product = 1;
        long digit;

        if (input < 10) {
            return true;
        } else {
            while (input > 0) {
                digit = input % 10;
                sum += digit;
                product *= digit;
                input = input / 10;
            }
            return sum == product;

        }

    }

    public static boolean isSunny(long input) {
        long nPlusOne = input + 1;
        double getRoot = Math.sqrt(nPlusOne);
        return getRoot == (int) getRoot;
    }

    public static boolean isSquare(long input) {
        double getRoot = Math.sqrt(input);
        return getRoot == (int) getRoot;
    }

    public static boolean isJumping(long input) {
        boolean isJumping = true;
        while(input >= 10) {
            int digit1 = (int) input % 10;
            input = input / 10;
            int digit2 = (int) input % 10;
            if (Math.abs(digit1 - digit2) != 1) {
                isJumping = false;
                break;
            }
        }
        return isJumping;
    }

    public static boolean isHappy(long input) {
        long newNumber = 0;
        ArrayList<Long> multiplesSad = new ArrayList<>();

         while (input > 0) {
            int digit = (int) input  % 10;
            digit = digit * digit;
            newNumber += digit;
            input = input / 10;
        }

        if (newNumber == 1 || newNumber == 10) {
            return true;
        }
        if (isMultiple().contains(newNumber)) {
            return false;
        }
        return (isHappy(newNumber));
    }

    private static ArrayList<Long> isMultiple() {
        ArrayList<Long> multiplesOf10 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            long multiple = 10 * i;
            multiplesOf10.add(multiple);
        }
        return multiplesOf10;
    }

}





