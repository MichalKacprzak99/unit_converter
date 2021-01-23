package main;

public class UnitConverterData {
    private final double valueToConvert;
    private final String beforeConversionUnitSymbol ;
    private final String afterConversionUnitSymbol;
    private final BaseSIQuantityConverter converter;

    public UnitConverterData(double valueToConvert, String beforeConversionUnitSymbol,
                             String afterConversionUnitSymbol, BaseSIQuantityConverter converter) {
        this.valueToConvert = valueToConvert;
        this.beforeConversionUnitSymbol = beforeConversionUnitSymbol;
        this.afterConversionUnitSymbol = afterConversionUnitSymbol;
        this.converter = converter;
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

    public BaseSIQuantityConverter getConverter() {
        return converter;
    }
}
