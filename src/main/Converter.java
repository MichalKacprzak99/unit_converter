package main;

public interface Converter {
    double convert(UnitConverterData unitConverterData);
    boolean checkIfConversionIsSupported(String beforeConversionUnitSymbol, String afterConversionUnitSymbol);

}
