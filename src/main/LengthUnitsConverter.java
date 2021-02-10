package main;

class ConverterToLengthBaseUnit extends ConverterToSIQuantityBaseUnit {
    public ConverterToLengthBaseUnit(String baseSIUnitSymbol) {
        super(baseSIUnitSymbol);
        conversionsFormulasToSIBaseUnit.put("cm", this::convertFromCentimeterToMeter);
        conversionsFormulasToSIBaseUnit.put("in", this::convertFromInchesToMeter);
    }

    private double convertFromCentimeterToMeter(double value) {
        return value / 100;
    }

    private double convertFromInchesToMeter(double value) { return value / 39.37; }
}


public class LengthUnitsConverter extends SIBaseQuantityConverter {

    public LengthUnitsConverter(String baseUnitSymbol){
        super(baseUnitSymbol, new ConverterToLengthBaseUnit(baseUnitSymbol));
        supportedConversionsFormulas.put("cm", this::convertToCentimeter);
        supportedConversionsFormulas.put("in", this::convertToInches);

    }

    private double convertToCentimeter(double value) {
        return value * 100;
    }

    private double convertToInches(double value) {
        return value * 39.37;
    }


}
