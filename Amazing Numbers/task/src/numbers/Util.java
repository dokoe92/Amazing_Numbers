package numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class Util {

    ArrayList<String> inputValues;
    ArrayList<String> props;
    ArrayList<String> propsToExclude;

    public Util() {
        this.inputValues = new ArrayList<>();
        this.props = new ArrayList<>();
        this.propsToExclude = new ArrayList<>();

    }


    public Request processInput(String input) {
        inputValues.clear();
        props.clear();
        propsToExclude.clear();
        String[] splitInput = input.split(" ");
        Collections.addAll(inputValues, splitInput);

        int numberOfValues = inputValues.size();

        if (numberOfValues < 3) {
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
            }
        } else if (isValidNumber(inputValues.get(1))) {
            ArrayList<String> invalidProps = new ArrayList<>();
            for (int i = 2; i < numberOfValues; i++) {
                if (isValidProperty(inputValues.get(i))) {
                    this.props.add(inputValues.get(i).toUpperCase());
                    if (inputValues.get(i).toUpperCase().contains("-")) {
                        propsToExclude.add(inputValues.get(i).toUpperCase());
                    }
                } else {
                    invalidProps.add(inputValues.get(i).toUpperCase());
                }
            }
            if (invalidProps.size() > 0) {
                printOutInvalidProps(invalidProps);
                return Request.INVALID_PROPERTY;
            } else {
                if (isMutually(this.props)) {
                    return Request.MUTUALLY_EXCLUSIVE;
                } else {
                    this.props.removeAll(propsToExclude);
                    this.propsToExclude = removeMinusFromExcludedProp(this.propsToExclude);
                    return Request.MULTIPLE_PROPS;
                }
            }
        } else {
            return Request.INVALID_NUMBER2;
        }
        return Request.EMPTY;
    }

    public ArrayList<String> removeMinusFromExcludedProp(ArrayList<String> listWithMinus) {
        ArrayList<String> listWithoutMinus = new ArrayList<>();
        for (String prop : listWithMinus) {
            String withoutMinus = prop.replace("-","");
            listWithoutMinus.add(withoutMinus);
        }
        return listWithoutMinus;
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
            String propToExcludeString = "-" + property.toString();
            if (property.toString().equals(prop.toUpperCase()) || propToExcludeString.equals(prop.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void printOutInvalidProps(ArrayList<String> props) {
        if (props != null && props.size() == 1) {
            String prop = props.get(0);
            System.out.println("The property [" + prop + "] is wrong");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, JUMPING, HAPPY, SAD SQUARE EVEN, ODD]");
        } else {
            StringBuilder sb = new StringBuilder("The properties [");
            for (String prop : props) {
                sb.append(prop).append(" ");
            }
            sb.append("] are wrong");
            System.out.println(sb);
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, JUMPING, HAPPY, SAD SQUARE EVEN, ODD]");
        }

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

    public boolean isMutually(ArrayList<String> props) {
        for (String prop : props) {
            String propWithoutMinus = "";
            String propWithMinus = "";
            if (prop.contains("-")) {
                propWithMinus = prop;
                propWithoutMinus = prop.replace("-", "");
            } else {
                propWithMinus = "-" + prop;
                propWithoutMinus = prop;
            }
            if (props.contains(propWithMinus) && props.contains(propWithoutMinus)) {
                return true;
            }
        }
        if ((props.contains("EVEN") && props.contains("ODD")) || (props.contains("DUCK") && props.contains("SPY")) || (props.contains("SUNNY") && props.contains("SQUARE")) || (props.contains("SAD") && props.contains("HAPPY"))) {
            return true;
        } else if ((props.contains("-EVEN") && props.contains("-ODD"))) {
            return true;
        }
        return false;
    }

    public boolean isMutually(String prop) {
        String propWithoutMinus = "";
        String propWithMinus = "";
        if (prop.contains("-")) {
            propWithMinus = prop;
            propWithoutMinus = prop.replace("-", "");
        } else {
            propWithMinus = "-" + prop;
            propWithoutMinus = prop;
        }
        if (this.props.contains(propWithMinus) && this.props.contains(propWithoutMinus)) {
            return true;
        }

        if (prop.equals("EVEN") && this.props.contains("ODD")) {
            return true;
        }
        if (prop.equals("ODD") && this.props.contains("EVEN")) {
            return true;
        }
        if (prop.equals("DUCK") && this.props.contains("SPY")) {
            return true;
        }
        if (prop.equals("SPY") && this.props.contains("DUCK")) {
            return true;
        }
        if (prop.equals("SUNNY") && this.props.contains("SQUARE")) {
            return true;
        }
        if (prop.equals("SQUARE") && this.props.contains("SUNNY")) {
            return true;
        }
        if (prop.equals("SAD") && this.props.contains("HAPPY")) {
            return true;
        }
        if (prop.equals("HAPPY") && this.props.contains("SAD")) {
            return true;
        }

        if (prop.equals("-EVEN") && this.props.contains("-ODD")) {
            return true;
        }
        if (prop.equals("-ODD") && this.props.contains("-EVEN")) {
            return true;
        }
        if (prop.equals("-DUCK") && this.props.contains("-SPY")) {
            return true;
        }
        if (prop.equals("-SPY") && this.props.contains("-DUCK")) {
            return true;
        }
        if (prop.equals("-SUNNY") && this.props.contains("-SQUARE")) {
            return true;
        }
        if (prop.equals("-SQUARE") && this.props.contains("-SUNNY")) {
            return true;
        }
        if (prop.equals("-SAD") && this.props.contains("-HAPPY")) {
            return true;
        }
        if (prop.equals("-HAPPY") && this.props.contains("-SAD")) {
            return true;
        }

        return false;


}


    public void printMutually(ArrayList<String> props) {
        StringBuilder sb = new StringBuilder("The request contains mutually exclusive properties: [");
        ArrayList<String> mutuallyProps = new ArrayList<>();
        for (String prop : props) {
            if (isMutually(prop)) {
                System.out.println(prop);
                mutuallyProps.add(prop);
            }
        }
        for (String prop : mutuallyProps) {
            sb.append(prop).append(" ");
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println("There are no numbers with these properties");
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


