package numbers;

import java.util.HashMap;

public class Number {
    private long number;
    private boolean isEven;
    private boolean isOdd;
    private boolean isBuzz;
    private boolean isDuck;
    private boolean isPalindromic;
    private boolean isGapful;
    private boolean isSpy;
    private HashMap<String, Boolean> properties;

    public Number(long number) {
        this.number = number;
        this.isEven = NumberChecker.isEven(this.number);
        this.isOdd = NumberChecker.isOdd(this.number);
        this.isBuzz = NumberChecker.isBuzz(this.number);
        this.isDuck = NumberChecker.isDuck(this.number);
        this.isPalindromic = NumberChecker.isPalindrom(this.number);
        this.isGapful = NumberChecker.isGapful(this.number);
        this.isSpy = NumberChecker.isSpy(this.number);
        this.properties = new HashMap<>();
        setProperties();
    }

    public HashMap<String, Boolean> getProperties() {
        return properties;
    }

    public long getNumber() {
        return number;
    }

    public void setProperties() {
        this.properties.put("EVEN", this.isEven);
        this.properties.put("ODD", this.isOdd);
        this.properties.put("BUZZ", this.isBuzz);
        this.properties.put("DUCK", this.isDuck);
        this.properties.put("PALINDROMIC", this.isPalindromic);
        this.properties.put("GAPFUL", this.isGapful);
        this.properties.put("SPY", this.isSpy);
    }

    public StringBuilder printNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" is ");
        sb.append(this.isBuzz ? "buzz " : "");
        sb.append(this.isDuck ? "duck " : "");
        sb.append(this.isPalindromic ? "palindrom " : "");
        sb.append(this.isGapful ? "gapful " : "");
        sb.append(this.isSpy ? "spy " : "");
        sb.append(this.isEven ? "even " : "");
        sb.append(this.isOdd ? "odd " : "");
        return sb;

    }


}
