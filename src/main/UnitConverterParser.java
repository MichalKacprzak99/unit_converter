package main;

public class UnitConverterParser{


    public UnitConverterData parse(String[] args){
        double valueToConvert = Double.parseDouble(args[0]);
        String beforeConversionUnitSymbol = args[1];
        String afterConversionUnitSymbol = args[2];
        return new UnitConverterData(valueToConvert, beforeConversionUnitSymbol, afterConversionUnitSymbol);
    }
}
