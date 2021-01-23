package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;


public abstract class BaseSIQuantityConverter implements Converter{

    protected final HashMap<String, DoubleUnaryOperator> supportedConversionsFormulas = new HashMap<>();
    private final ConverterToSIQuantityBaseUnit converterToSIQuantityBaseUnit;

    BaseSIQuantityConverter(String baseSIUnitSymbol, ConverterToSIQuantityBaseUnit converterToSIQuantityBaseUnit){
        this.converterToSIQuantityBaseUnit = converterToSIQuantityBaseUnit;
        supportedConversionsFormulas.put(baseSIUnitSymbol, value -> value);

    }

    @Override
    public boolean checkIfConversionIsSupported(String beforeConversionUnitSymbol, String afterConversionUnitSymbol){
        Set<String> possibleUnits= supportedConversionsFormulas.keySet();
        return possibleUnits.containsAll(new HashSet<>(Arrays.asList(beforeConversionUnitSymbol,afterConversionUnitSymbol)));
    }

    @Override
    public double convert(String beforeConversionUnitSymbol, String afterConversionUnitSymbol, Double valueToConvert) {
        double valueInBaseUnit = converterToSIQuantityBaseUnit.convertValueToBaseUnit(beforeConversionUnitSymbol,valueToConvert);
        DoubleUnaryOperator conversionFormula = supportedConversionsFormulas.get(afterConversionUnitSymbol);
        return conversionFormula.applyAsDouble(valueInBaseUnit);
    }


}
