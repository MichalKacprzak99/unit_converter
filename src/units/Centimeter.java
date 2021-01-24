package units;

public class Centimeter extends Unit {

    public Centimeter() {
        super("cm", "m");
    }

    public double convertValueToBaseUnit(double value) {
        return value / 100;
    }

}
