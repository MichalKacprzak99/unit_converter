package tests.inputHandling;
import main.UnitConverterData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.UnitConverterParser;

@RunWith(JUnit4.class)
public class UnitConverterParserTest {
    private UnitConverterParser unitConverterParserUnderTest;

    @org.junit.Before
    public void setUp() {
        unitConverterParserUnderTest = new UnitConverterParser();
    }

    @Test
    public void ShouldReturnUnitConverterDataWhenParsingUserInput(){
        UnitConverterData result = unitConverterParserUnderTest.parse(new String[] {"666", "cm", "in"});
        Assert.assertNotNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionWhenConversionIsNotSupported(){
        unitConverterParserUnderTest.parse(new String[] {"666", "cm", "kg"});
    }

}
