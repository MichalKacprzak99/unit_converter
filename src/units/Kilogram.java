package units;

public class Kilogram extends UnitBase {

    public Kilogram() {
        super("kg", "kg");
        addPossibleConversion("lb", this::convertToPounds);

    }

    public double convertToPounds(double value) {
        return value * 2.20462262;
    }


}
