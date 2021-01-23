package main;

public class UnitConverter {


    private final UnitConverterParser unitConverterParser;
    public UnitConverter(){
        unitConverterParser = new UnitConverterParser();
    }

    public double convert(String[] args){
        UnitConverterData unitConverterDataFromInput = unitConverterParser.parse(args);
        double valueToConvert = unitConverterDataFromInput.getValueToConvert();
        String beforeConversionUnitSymbol = unitConverterDataFromInput.getBeforeConversionUnitSymbol();
        String afterConversionUnitSymbol = unitConverterDataFromInput.getAfterConversionUnitSymbol();
        BaseSIQuantityConverter converter = unitConverterDataFromInput.getConverter();
        return converter.convert(beforeConversionUnitSymbol, afterConversionUnitSymbol, valueToConvert);

    }


}
