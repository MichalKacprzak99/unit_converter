public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        validator.validateUserInput(args);
        Converter converter = new Converter();
        converter.initializeConversion(validator.getUserInput());
        converter.convert();
        double valueAfterConversion = converter.getValueAfterConversion();
        System.out.println(valueAfterConversion);
    }
}
