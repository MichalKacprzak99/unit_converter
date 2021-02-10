package main;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

public abstract class ConverterToSIQuantityBaseUnit implements ToBaseUnitConverter {
    Map<String, DoubleUnaryOperator> conversionsFormulasToSIBaseUnit = new HashMap<>();


    public ConverterToSIQuantityBaseUnit(String SIBaseUnitSymbol) {
        conversionsFormulasToSIBaseUnit.put(SIBaseUnitSymbol, value -> value);
    }

    @Override
    public double convertValueToBaseUnit(String unitSymbolToConvert, double valueToConvert) {
        DoubleUnaryOperator conversionFormula = conversionsFormulasToSIBaseUnit.get(unitSymbolToConvert);
        return conversionFormula.applyAsDouble(valueToConvert);
    }
}
