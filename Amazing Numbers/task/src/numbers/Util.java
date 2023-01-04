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

        switch(numberOfValues) {
            case 1:
                if (isValidNumber(inputValues.get(0))) {
                    long value1Single = parseToLong(inputValues.get(0));

                    if(value1Single == 0) {
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

    public long parseToLong(String input) {
        return Long.parseLong(input);
    }

}


