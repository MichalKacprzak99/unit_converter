package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitConverter {

    private final Map<String, SIBaseQuantityConverter> baseSIQuantityConverters = new HashMap<>();
    private final UnitConverterParser unitConverterParser;
    private final UnitConverterValidator UnitConverterValidator;
    public UnitConverter(){
        baseSIQuantityConverters.put("length", new LengthUnitsConverter("m"));
        baseSIQuantityConverters.put("mass", new MassUnitsConverter("kg"));
        UnitConverterValidator = new UnitConverterValidator();
        unitConverterParser = new UnitConverterParser();
    }

    public double convert(String[] args){
        List<String> validatorResult = UnitConverterValidator.validateInput(args);
        if(!validatorResult.isEmpty()){
            throw new IllegalArgumentException(String.valueOf(validatorResult));
        }

        UnitConverterData unitConverterData = unitConverterParser.parse(args);
        SIBaseQuantityConverter converter = findSIQuantityConverter(unitConverterData);
        return converter.convert(unitConverterData);

    }

    private SIBaseQuantityConverter findSIQuantityConverter(UnitConverterData unitConverterData){
        String beforeConversionUnitSymbol = unitConverterData.getBeforeConversionUnitSymbol();
        String afterConversionUnitSymbol = unitConverterData.getAfterConversionUnitSymbol();
        for (SIBaseQuantityConverter converter : baseSIQuantityConverters.values()) {
            if(converter.checkIfConversionIsSupported(beforeConversionUnitSymbol, afterConversionUnitSymbol)){
                return converter;
            }
        }
        throw new IllegalArgumentException("Converter is not founded. The conversion from " + beforeConversionUnitSymbol + " to " + afterConversionUnitSymbol +" is not supported");
    }


}
