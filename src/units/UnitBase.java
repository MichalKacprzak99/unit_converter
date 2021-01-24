package units;

import java.util.HashMap;
import java.util.function.DoubleUnaryOperator;

public class UnitBase extends Unit implements UnitBaseInterface {

    private final HashMap<String, DoubleUnaryOperator> possibleConversions = new HashMap<>();

    public UnitBase(String unitSymbol, String unitBaseSymbol) {
        super(unitSymbol, unitBaseSymbol);
    }

    public void addPossibleConversion(String unitSymbol, DoubleUnaryOperator conversionFormula){
        possibleConversions.put(unitSymbol, conversionFormula);
    }

    public DoubleUnaryOperator getConversionFormula(String conversionUnitSymbol){
        return possibleConversions.get(conversionUnitSymbol);
    }

    @Override
    public double convertValueToUnit(double valueToConvert, String convertToUnit ) {
        DoubleUnaryOperator conversionFormula = getConversionFormula(convertToUnit);
        return conversionFormula.applyAsDouble(valueToConvert);
    }
}
