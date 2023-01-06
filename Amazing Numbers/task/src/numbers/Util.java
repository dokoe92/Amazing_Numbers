package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class Util {

    ArrayList<String> inputValues;

    public Util() {
        inputValues = new ArrayList<>();
    }

    public Request processInput(String input) {
        inputValues.clear();
        String[] splitInput = input.split(" ");
        Collections.addAll(inputValues, splitInput);

        int numberOfValues = inputValues.size();

        switch (numberOfValues) {
            case 1:
                if (isValidNumber(inputValues.get(0))) {
                    long value1Single = parseToLong(inputValues.get(0));

                    if (value1Single == 0) {
                        return Request.ZERO;
                    }
                    if (value1Single < 0) {
                        return Request.INVALID_NUMBER1;
                    } else {
                        return Request.ONE_NUMBER;
                    }
                } else {
                    return Request.INVALID_NUMBER1;
                }


            case 2:
                if (isValidNumber(inputValues.get(1))) {
                    if (parseToLong(inputValues.get(1)) < 0) {
                        return Request.INVALID_NUMBER2;
                    } else {
                        return Request.TWO_NUMBERS;
                    }
                } else {
                    return Request.INVALID_NUMBER2;
                }
            case 3:
                if (isValidNumber(inputValues.get(1))) {

                    if (isValidProperty(inputValues.get(2).toUpperCase())) {
                        return Request.THREE_INPUTS;
                    } else {
                        return Request.INVALID_PROPERTY;
                    }
                } else {
                    return Request.INVALID_NUMBER2;
                }
            case 4:
                if (isValidNumber(inputValues.get(1))) {
                    if (isValidProperty(inputValues.get(2), inputValues.get(3))) {
                        if (!isMutually(inputValues.get(2), inputValues.get(3))) {
                            return Request.FOUR_INPUTS;
                        } else {
                            return Request.MUTUALLY_EXCLUSIVE;
                        }
                    } else {
                        return Request.INVALID_PROPERTY;
                    }

                } else {
                    return Request.INVALID_NUMBER2;
                }
            default:
                return Request.EMPTY;
        }

    }


    public boolean isValidNumber(String input) {
        try {
            parseToLong(input);
            return true;
        } catch (InputMismatchException | NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidProperty(String prop) {
        for (Property property : Property.values()) {
            if (property.toString().equals(prop.toUpperCase())) {
                return true;
            }
        }
        System.out.println("The property [" + prop + "] is wrong");
        System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE EVEN, ODD]");
        return false;
    }


    public boolean isValidProperty(String prop1, String prop2) {
        boolean prop1Found = false;
        boolean prop2Found = false;
        int trueCounter = 0;
        for (Property property : Property.values()) {
            if (property.toString().equals(prop1.toUpperCase())) {
                prop1Found = true;
                trueCounter++;
            }
            if (property.toString().equals(prop2.toUpperCase())) {
                prop2Found = true;
                trueCounter++;
            }
        }
        if (prop1Found && prop2Found) {
            return true;
        } else {
            if (trueCounter == 1) {
                System.out.println("The property [" + (prop1Found ? "" : prop1.toUpperCase()) + (prop2Found ? "" : prop2.toUpperCase()) + "] is wrong");
            } else {
                System.out.println("The properties [" + (prop1Found ? "" : prop1.toUpperCase()) + "" + (prop2Found ? "" : prop2.toUpperCase()) + "] are wrong");
            }

            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE EVEN, ODD]");
            return false;
        }
    }

    public boolean isMutually(String prop1, String prop2) {
        if (isMutually(prop1, prop2, "EVEN", "ODD")) {
            return true;
        } else if (isMutually(prop1, prop2, "DUCK", "SPY")) {
            return true;
        } else return isMutually(prop1, prop2, "SUNNY", "SQUARE");
    }

    public boolean isMutually(String prop1, String prop2, String propCheck1, String propCheck2) {
        return (prop1.toUpperCase().equals(propCheck1)) && (prop2.toUpperCase().equals(propCheck2)) || ((prop2.toUpperCase().equals(propCheck1)) && (prop1.toUpperCase().equals(propCheck2)));
    }


    public long parseToLong(String input) {
        return Long.parseLong(input);
    }


}


