package tests.inputHandling;
import main.UnitConverterValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;

@RunWith(JUnit4.class)
public class UnitConverterValidatorTest {
    private UnitConverterValidator unitConverterValidatorUnderTest;

    @org.junit.Before
    public void setUp() {
        unitConverterValidatorUnderTest = new UnitConverterValidator();
    }

    @Test
    public void shouldValidateUserInput() {
        List<String> result = unitConverterValidatorUnderTest.validateInput(new String[] {"666", "cm", "in"});
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldCatchTwoErrorsDuringUserInputValidation() {
        List<String> result = unitConverterValidatorUnderTest.validateInput(new String[] {"66v", "cm"});
        Assert.assertEquals("Too few arguments, you need to provide exactly 3 arguments", result.get(0));
        Assert.assertEquals("The first argument is not an number", result.get(1));
    }

    @Test
    public void shouldCatchNumberFormatExceptionDuringUserInputValidation() {
        List<String> result = unitConverterValidatorUnderTest.validateInput(new String[] {"66v", "cm", "m"});

        Assert.assertEquals("The first argument is not an number", result.get(0));
    }

    @Test
    public void shouldFindThaTNotProperNumberOfArgumentsWasProvidedDuringUserInputValidation() {
        List<String> result = unitConverterValidatorUnderTest.validateInput(new String[] {"66v", "cm", "m", "test"});

        Assert.assertEquals("Too many arguments, you need to provide exactly 3 arguments", result.get(0));
    }

}

