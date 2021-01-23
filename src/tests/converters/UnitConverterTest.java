package tests.converters;
import main.UnitConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UnitConverterTest {
    private UnitConverter unitConverterUnderTest;

    @org.junit.Before
    public void setUp() {
        unitConverterUnderTest = new UnitConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenConversionIsNotSupported (){
        unitConverterUnderTest.convert(new String[] {"666", "cm", "kg"});
    }

    @Test
    public void shouldReturnCorrectResultForMToCmConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"1.0", "m", "cm"});
        Assert.assertEquals(result, 100, 0.001);
    }

    @Test
    public void shouldReturnCorrectResultForCmToMConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"100.0", "cm", "m" });
        Assert.assertEquals(result, 1.0, 0.001);
    }

    @Test
    public void shouldReturnCorrectResultForInToMConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"39.37", "in", "m" });
        Assert.assertEquals(result, 1.0, 0.001);
    }

    @Test
    public void shouldReturnCorrectResultForMToInConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"50.0", "m", "in"});
        Assert.assertEquals(result, 1968.50, 0.001);
    }

    @Test
    public void shouldReturnCorrectResultForKgLbConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"1.0", "kg", "lb"});
        Assert.assertEquals(result, 2.2046, 0.001);
    }
    @Test
    public void shouldReturnCorrectResultForLbKgConversion(){
        double result =unitConverterUnderTest.convert(new String[]{"2.2046", "lb", "kg" });
        Assert.assertEquals(result, 1, 0.001);
    }

}
