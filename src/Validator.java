import java.util.HashMap;

public class Validator {


    private final HashMap<String, String> userInput = new HashMap<>();
    public void validateUserInput(String[] args){

        try{
            userInput.put("valueToConvert", String.valueOf(Double.parseDouble(args[0])));
            userInput.put("beforeConversionUnit", args[1]);
            userInput.put("afterConversionUnit", args[2]);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("The first argument is not an number");
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("To few arguments, " + args.length + " arguments were given, where there should be 3");
        }

    }

    public HashMap<String, String> getUserInput() {
        return userInput;
    }


}
