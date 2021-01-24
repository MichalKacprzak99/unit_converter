import units.*;

import java.util.HashMap;


public class Converter {

    private Unit beforeConversionUnit;
    private Unit afterConversionUnit;
    private double valueBeforeConversion;
    private double valueAfterConversion;
    private final HashMap<String, UnitBase> unitsBases = new HashMap<>();
    private final UnitCreator unitCreator = new UnitCreator();

    public Converter(){

        unitsBases.put("m", new Meter());
        unitsBases.put("kg", new Kilogram());

    }

    public void initializeConversion(HashMap<String, String> userInput){
        valueBeforeConversion = Double.parseDouble(userInput.get("valueToConvert"));
        beforeConversionUnit = unitCreator.createUnit(userInput.get("beforeConversionUnit"));
        afterConversionUnit = unitCreator.createUnit(userInput.get("afterConversionUnit"));

        checkUnitsCompatibility();
    }


    private void checkUnitsCompatibility(){
        if (!beforeConversionUnit.getUnitBaseSymbol().equals(afterConversionUnit.getUnitBaseSymbol())) {
            throw new IllegalArgumentException("It is impossible to convert from " +
                    beforeConversionUnit.getUnitSymbol() + " to " + afterConversionUnit.getUnitSymbol());
        }
    }


    public void convert(){

        UnitBase unitBase = unitsBases.get(beforeConversionUnit.getUnitBaseSymbol());
        double valueInBaseUnit = beforeConversionUnit.convertValueToBaseUnit(valueBeforeConversion);
        valueAfterConversion = unitBase.convertValueToUnit(valueInBaseUnit, afterConversionUnit.getUnitSymbol());

    }


    public double getValueAfterConversion() {
        return valueAfterConversion;
    }

}
