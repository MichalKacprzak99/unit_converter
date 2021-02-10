package main;

import java.util.*;
import java.util.function.DoubleUnaryOperator;


public abstract class SIBaseQuantityConverter implements Converter {

    protected final Map<String, DoubleUnaryOperator> supportedConversionsFormulas = new HashMap<>();
    private final ConverterToSIQuantityBaseUnit converterToSIQuantityBaseUnit;

    SIBaseQuantityConverter(String baseSIUnitSymbol, ConverterToSIQuantityBaseUnit ConverterToSIQuantityBaseUnit){
        this.converterToSIQuantityBaseUnit = ConverterToSIQuantityBaseUnit;
        supportedConversionsFormulas.put(baseSIUnitSymbol, value -> value);

    }

    @Override
    public boolean checkIfConversionIsSupported(String beforeConversionUnitSymbol, String afterConversionUnitSymbol){
        Set<String> possibleUnits= supportedConversionsFormulas.keySet();
        return possibleUnits.containsAll(new HashSet<>(Arrays.asList(beforeConversionUnitSymbol,afterConversionUnitSymbol)));
    }

    @Override
    public double convert(UnitConverterData unitConverterData) {
        double valueToConvert = unitConverterData.getValueToConvert();
        String beforeConversionUnitSymbol = unitConverterData.getBeforeConversionUnitSymbol();
        String afterConversionUnitSymbol = unitConverterData.getAfterConversionUnitSymbol();
        double valueInBaseUnit = converterToSIQuantityBaseUnit.convertValueToBaseUnit(beforeConversionUnitSymbol,valueToConvert);
        DoubleUnaryOperator conversionFormula = supportedConversionsFormulas.get(afterConversionUnitSymbol);
        return conversionFormula.applyAsDouble(valueInBaseUnit);
    }


}