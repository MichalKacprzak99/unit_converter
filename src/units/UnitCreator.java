package units;

import java.util.HashMap;

public class UnitCreator {

    private final HashMap<String, Unit> units = new HashMap<>();

    public UnitCreator(){
        units.put("kg", new Kilogram());
        units.put("in", new Inch());
        units.put("m", new Meter());
        units.put("lb", new Pound());
        units.put("cm", new Centimeter());
    }

    public Unit createUnit(String unitSymbol){
        Unit unit = units.get(unitSymbol);
        if (unit == null){
            throw new NullPointerException("This converter don't handle conversion with this unit: " + unitSymbol);
        }
        return unit;
    }
}
