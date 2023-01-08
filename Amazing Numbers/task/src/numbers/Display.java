package numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {

    Long[] numbers;
    Util util;

    public Display() {
        util = new Util();
    }


    public void printConsole() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println(" * the first parameter represents a starting number");
        System.out.println(" * the second parameter shows how many consecutive numbers are to be printed");
        System.out.println("- two natural numbers and properties to search for");
        System.out.println("- a property preceded by minus must not be present in numbers");
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
                case TWO_NUMBERS ->
                        propertyOfList(util.parseToLong(util.inputValues.get(0)), util.parseToLong(util.inputValues.get(1)));
                case MULTIPLE_PROPS ->
                        propertyOfList(util.parseToLong(util.inputValues.get(0)), util.parseToLong(util.inputValues.get(1)), util.props);
                case MUTUALLY_EXCLUSIVE -> util.printMutually(util.props);
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
        Number number = new Number(input);
        System.out.println("Properties of " + input);
        System.out.println(number.printNumber());
    }

    public void propertyOfList(long startNumber, long length) {
        propertyOfListOutput(startNumber);
        for (long i = 0; i < length; i++) {
            Number number = new Number(startNumber + i);
            System.out.println(number.printNumber());
        }
    }

    public void propertyOfList(long startNumber, long length, String property) {
        ArrayList<Number> numbersWithProperty = new ArrayList<>();
        int counter = 0;
        long nextNumber = new Number(startNumber).getNumber();
        boolean foundNumbersWithProperties = false;

        while (!foundNumbersWithProperties) {
            if (new Number(nextNumber).getProperties().get(property.toUpperCase())) {
                numbersWithProperty.add(new Number(nextNumber));
                counter++;
            }
            nextNumber++;
            if (counter == length) {
                foundNumbersWithProperties = true;
            }
        }

        for (Number number : numbersWithProperty) {
            System.out.println(number.printNumber());
        }
    }

    public void propertyOfList(long startNumber, long length, ArrayList<String> props) {
        ArrayList<Number> numberList = new ArrayList<>();
        ArrayList<Number> numbersWithProperty = new ArrayList<>();

        boolean foundNumbersWithProperties = false;

        while (!foundNumbersWithProperties) {
            Number numberToCheck = new Number(startNumber);
            numberList.add(numberToCheck);
            if (util.props.size() != 0) {
                if (numberToCheck.getProps().containsAll(props)) {
                    numbersWithProperty.add(numberToCheck);
                }
                if (numberToCheck.getProps().containsAll(util.propsToExclude) && util.propsToExclude.size() != 0) {
                    numbersWithProperty.remove(numberToCheck);
                }
            } else {
                for (String prop : util.propsToExclude) {
                    if (numberToCheck.getProps().contains(prop)) {
                        numberList.remove(numberToCheck);
                    }
                }
            }
            if (numbersWithProperty.size() == length || (numberList.size() == length && util.props.size() == 0)) {
                foundNumbersWithProperties = true;
            }
            startNumber++;

        }
        if (numbersWithProperty.size() == 0) {
            for (Number number : numberList) {
                System.out.println(number.printNumber());
            }
        } else {
            for (Number number : numbersWithProperty) {
                System.out.println(number.printNumber());
            }
        }

    }

    public void propertyOfList(long startNumber, long length, String property1, String property2) {
        ArrayList<Number> numbersWithProperty = new ArrayList<>();
        int counter = 0;
        long nextNumber = new Number(startNumber).getNumber();
        boolean foundNumbersWithProperties = false;

        while (!foundNumbersWithProperties) {
            Number numberToCheck = new Number(nextNumber);
            if ((numberToCheck.getProperties().get(property1.toUpperCase()) && (numberToCheck.getProperties().get(property2.toUpperCase())))) {
                numbersWithProperty.add(numberToCheck);
                counter++;
            }
            nextNumber++;
            if (counter == length) {
                foundNumbersWithProperties = true;
            }
        }

        for (Number number : numbersWithProperty) {
            System.out.println(number.printNumber());
        }
    }

    public void propertyOfListOutput(long input) {
        Number number = new Number(input);
        number.printNumber();
    }

}
