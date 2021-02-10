package main;
import java.util.List;

public class UnitConverter {


    private final UnitConverterParser unitConverterParser;
    private final UnitConverterValidator UnitConverterValidator;
    public UnitConverter(){
        UnitConverterValidator = new UnitConverterValidator();
        unitConverterParser = new UnitConverterParser();
    }

    public double convert(String[] args){
        List<String> validatorResult = UnitConverterValidator.validateInput(args);
        if(!validatorResult.isEmpty()){
            throw new IllegalArgumentException(String.valueOf(validatorResult));
        }

        UnitConverterData unitConverterData = unitConverterParser.parse(args);
        double valueToConvert = unitConverterData.getValueToConvert();
        String beforeConversionUnitSymbol = unitConverterData.getBeforeConversionUnitSymbol();
        String afterConversionUnitSymbol = unitConverterData.getAfterConversionUnitSymbol();
        SIBaseQuantityConverter converter = unitConverterData.getConverter();
        return converter.convert(beforeConversionUnitSymbol, afterConversionUnitSymbol, valueToConvert);

    }


}
