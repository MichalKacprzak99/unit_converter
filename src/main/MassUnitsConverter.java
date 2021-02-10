package main;


class ConverterToMassBaseUnit extends ConverterToSIQuantityBaseUnit {
    public ConverterToMassBaseUnit(String baseSIUnitSymbol) {
        super(baseSIUnitSymbol);
        conversionsFormulasToSIBaseUnit.put("lb", this::convertFromPoundToBase );
    }
    private double convertFromPoundToBase(double value){ return value / 2.20462262; }
}


public class MassUnitsConverter extends SIBaseQuantityConverter {
    public MassUnitsConverter(String baseUnitSymbol){
        super(baseUnitSymbol, new ConverterToMassBaseUnit(baseUnitSymbol));
        supportedConversionsFormulas.put("lb", this::convertToPounds);

    }
    private double convertToPounds(double value) {
        return value * 2.20462262;
    }

}
