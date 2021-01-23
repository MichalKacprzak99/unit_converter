package main;

public class Main {
    public static void main(String[] args) {
        UnitConverterValidator unitConverterValidator = new UnitConverterValidator();
        if(unitConverterValidator.validateInput(args)){
            UnitConverter unitConverter = new UnitConverter();
            double valueAfterConversion = unitConverter.convert(args);
            System.out.println(valueAfterConversion);
        }

    }
}
