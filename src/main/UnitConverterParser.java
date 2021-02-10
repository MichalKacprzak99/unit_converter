package main;

import java.util.HashMap;
import java.util.Map;

public class UnitConverterParser{
    private final Map<String, SIBaseQuantityConverter> baseSIQuantityConverters = new HashMap<>();

    public UnitConverterParser() {
        baseSIQuantityConverters.put("length", new LengthUnitsConverter("m"));
        baseSIQuantityConverters.put("mass", new MassUnitsConverter("kg"));
    }

    public UnitConverterData parse(String[] args){
        double valueToConvert = Double.parseDouble(args[0]);
        String beforeConversionUnitSymbol = args[1];
        String afterConversionUnitSymbol = args[2];
        SIBaseQuantityConverter converter = findSIQuantityConverter(beforeConversionUnitSymbol, afterConversionUnitSymbol);
        return new UnitConverterData(valueToConvert, beforeConversionUnitSymbol, afterConversionUnitSymbol, converter);
    }

    private SIBaseQuantityConverter findSIQuantityConverter(String beforeConversionUnitSymbol, String afterConversionUnitSymbol){
        for (SIBaseQuantityConverter converter : baseSIQuantityConverters.values()) {
            if(converter.checkIfConversionIsSupported(beforeConversionUnitSymbol, afterConversionUnitSymbol)){
                return converter;
            }
        }
        throw new IllegalArgumentException("Converter is not founded. The conversion from " + beforeConversionUnitSymbol + " to " + afterConversionUnitSymbol +" is not supported");
    }
}
