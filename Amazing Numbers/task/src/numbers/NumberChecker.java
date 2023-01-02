package numbers;

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
}





