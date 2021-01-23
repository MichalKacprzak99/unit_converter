package tests.inputHandling;
import main.UnitConverterValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UnitConverterValidatorTest {
    private UnitConverterValidator unitConverterValidatorUnderTest;

    @org.junit.Before
    public void setUp() {
        unitConverterValidatorUnderTest = new UnitConverterValidator();
    }

    @Test
    public void shouldValidateUserInput() {
        boolean result = unitConverterValidatorUnderTest.validateInput(new String[] {"666", "cm", "in"});
        Assert.assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenValidateUserInputWithTooFewArguments() {
        unitConverterValidatorUnderTest.validateInput(new String[] {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenValidateUserInputWithTooManyArguments() {
        unitConverterValidatorUnderTest.validateInput(new String[] {"666", "cm", "kg", "test"});
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionWhenFirstArgumentIsNotDouble() {
        unitConverterValidatorUnderTest.validateInput(new String[] {"test", "cm", "m"});
    }

}

