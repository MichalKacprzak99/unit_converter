package main;

public interface Converter {
    double convert(String beforeConversionUnitSymbol, String afterConversionUnitSymbol, Double valueToConvert);
    boolean checkIfConversionIsSupported(String beforeConversionUnitSymbol, String afterConversionUnitSymbol);

}
