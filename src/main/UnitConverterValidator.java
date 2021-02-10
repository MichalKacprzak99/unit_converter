package main;
import java.util.ArrayList;
import java.util.List;

public class UnitConverterValidator{

    private final int properNumberOfArguments = 3;

    public List<String> validateInput(String[] args){
        List<String> validationResult = new ArrayList<>();
        if (!isProperNumberOfArgumentsProvided(args)) {
            validationResult.add("Too" + ( args.length > 3 ? " many ": " few ") +
                    "arguments, you need to provide exactly 3 arguments");
        }
        try{
            Double.parseDouble(args[0]);
        }
        catch (NumberFormatException e){
            validationResult.add("The first argument is not an number");
        }
        return validationResult;
    }

    private boolean isProperNumberOfArgumentsProvided(String[] args) {
        return args.length == properNumberOfArguments;
    }


}
