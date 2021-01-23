package main;

import java.util.HashMap;

public class UnitConverterParser implements UserInputParser {
    private final HashMap<String, BaseSIQuantityConverter> baseSIQuantityConverters = new HashMap<>();

    public UnitConverterParser() {
        baseSIQuantityConverters.put("length", new LengthUnitsConverter("m"));
        baseSIQuantityConverters.put("mass", new MassUnitsConverter("kg"));
    }

    @Override
    public UnitConverterData parse(String[] args){
        double valueToConvert = Double.parseDouble(args[0]);
        String beforeConversionUnitSymbol = args[1];
        String afterConversionUnitSymbol = args[2];
        BaseSIQuantityConverter converter = findSIQuantityConverter(beforeConversionUnitSymbol, afterConversionUnitSymbol);
        return new UnitConverterData(valueToConvert, beforeConversionUnitSymbol, afterConversionUnitSymbol, converter);
    }

    private BaseSIQuantityConverter findSIQuantityConverter(String beforeConversionUnitSymbol, String afterConversionUnitSymbol){
        for (BaseSIQuantityConverter baseSIQuantityConverter : baseSIQuantityConverters.values()) {
            if(baseSIQuantityConverter.checkIfConversionIsSupported(beforeConversionUnitSymbol, afterConversionUnitSymbol)){
                return baseSIQuantityConverter;
            }
        }
        throw new IllegalArgumentException("Converter is not founded. The conversion from " + beforeConversionUnitSymbol + " to " + afterConversionUnitSymbol +" is not supported");
    }
}
