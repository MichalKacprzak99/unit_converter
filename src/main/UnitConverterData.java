package main;

public class UnitConverterData {
    private final double valueToConvert;
    private final String beforeConversionUnitSymbol ;
    private final String afterConversionUnitSymbol;


    public UnitConverterData(double valueToConvert, String beforeConversionUnitSymbol,
                             String afterConversionUnitSymbol) {
        this.valueToConvert = valueToConvert;
        this.beforeConversionUnitSymbol = beforeConversionUnitSymbol;
        this.afterConversionUnitSymbol = afterConversionUnitSymbol;

    }

    public double getValueToConvert() {
        return valueToConvert;
    }

    public String getBeforeConversionUnitSymbol() {
        return beforeConversionUnitSymbol;
    }

    public String getAfterConversionUnitSymbol() {
        return afterConversionUnitSymbol;
    }


}
