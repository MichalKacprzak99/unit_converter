package units;

public class Inch extends Unit {

    public Inch() {
        super("in", "m");

    }

    public double convertValueToBaseUnit(double value) {
        return value / 39.26;
    }

}
