package main;

public class Main {
    public static void main(String[] args) {
        try {
            UnitConverter unitConverter = new UnitConverter();
            double valueAfterConversion = unitConverter.convert(args);
            System.out.println(valueAfterConversion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}