package numbers;

import java.util.ArrayList;
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
    private boolean isSunny;
    private boolean isSquare;
    private boolean isJumping;
    private boolean isHappy;
    private boolean isSad;
    private HashMap<String, Boolean> properties;
    private ArrayList<String> props;

    public Number(long number) {
        this.number = number;
        this.isEven = NumberChecker.isEven(this.number);
        this.isOdd = NumberChecker.isOdd(this.number);
        this.isBuzz = NumberChecker.isBuzz(this.number);
        this.isDuck = NumberChecker.isDuck(this.number);
        this.isPalindromic = NumberChecker.isPalindrom(this.number);
        this.isGapful = NumberChecker.isGapful(this.number);
        this.isSpy = NumberChecker.isSpy(this.number);
        this.isSunny = NumberChecker.isSunny(this.number);
        this.isSquare = NumberChecker.isSquare(this.number);
        this.isJumping = NumberChecker.isJumping(this.number);
        this.properties = new HashMap<>();
        setProperties();
        this.props = new ArrayList<>();
        setProps();
    }

    public HashMap<String, Boolean> getProperties() {
        return properties;
    }

    public long getNumber() {
        return number;
    }

    public ArrayList<String> getProps() {
        return this.props;
    }

    public void setProperties() {
        setEven();
        setOdd();
        setBuzz();
        setDuck();
        setPalindromic();
        setGapful();
        setSpy();
        setSunny();
        setSquare();
        setJumping();
        setHappyUnhappy();
    }

    public void setProps(){
        this.props.addAll(getProperties().keySet());
    }

    public void setEven () {
        if (NumberChecker.isEven(this.number)) {
            this.properties.put("EVEN", this.isEven);
        }
    }

    public void setOdd() {
        if (NumberChecker.isOdd(this.number)) {
            this.properties.put("ODD", this.isOdd);
        }
    }

    public void setBuzz() {
        if (NumberChecker.isBuzz(this.number)) {
            this.properties.put("BUZZ", this.isBuzz);
        }
    }

    public void setDuck() {
        if (NumberChecker.isDuck(this.number)) {
            this.properties.put("DUCK", this.isDuck);
        }
    }

    public void setPalindromic() {
        if (NumberChecker.isPalindrom(this.number)) {
            this.properties.put("PALINDROMIC", this.isPalindromic);
        }
    }

    public void setGapful() {
        if (NumberChecker.isGapful(this.number)) {
            this.properties.put("GAPFUL", this.isGapful);
        }
    }

    public void setSpy() {
        if (NumberChecker.isSpy(this.number)) {
            this.properties.put("SPY", this.isSpy);
        }
    }

    public void setSunny() {
        if (NumberChecker.isSunny(this.number)) {
            this.properties.put("SUNNY", this.isSunny);
        }
    }

    public void setSquare() {
        if (NumberChecker.isSquare(this.number)) {
            this.properties.put("SQUARE", this.isSquare);
        }
    }

    public void setJumping() {
        if(NumberChecker.isJumping(this.number)) {
            this.properties.put("JUMPING", this.isSquare);
        }
    }

    public void setHappyUnhappy() {
        boolean isHappy = NumberChecker.isHappy(this.number);
        if (isHappy) {
            this.isHappy = true;
            this.isSad = false;
            this.properties.put("HAPPY", this.isHappy);
        } else {
            this.isHappy = false;
            this.isSad = true;
            this.properties.put("SAD", this.isSad);
        }
    }




    public StringBuilder printNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" is ");
        sb.append(this.isBuzz ? "buzz " : "");
        sb.append(this.isDuck ? "duck " : "");
        sb.append(this.isPalindromic ? "palindrom " : "");
        sb.append(this.isGapful ? "gapful " : "");
        sb.append(this.isSpy ? "spy " : "");
        sb.append(this.isSunny ? "sunny " : "");
        sb.append(this.isSquare ? "square " : "");
        sb.append(this.isJumping ? "jumping " : "");
        sb.append(this.isHappy ? "happy " : "");
        sb.append(this.isSad ? "sad " : "");
        sb.append(this.isEven ? "even " : "");
        sb.append(this.isOdd ? "odd " : "");
        return sb;

    }


}
