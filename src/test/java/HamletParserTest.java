import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        assertTrue(hamletParser.findHamlet(hamletText));

        // When
        hamletParser.changeHamletToLeon();

        // Then
        assertFalse(hamletParser.findHamlet(hamletParser.getHamletData()));
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        assertTrue(hamletParser.findHoratio(hamletText));

        // When
        hamletParser.changeHoratioToTariq();

        // Then
        assertFalse(hamletParser.findHoratio(hamletParser.getHamletData()));
    }

    @Test
    public void testFindHoratio() {
        // When
        boolean actualTrue = hamletParser.findHoratio(hamletParser.getHamletData());

        hamletParser.changeHoratioToTariq();
        boolean actualFalse = hamletParser.findHoratio(hamletParser.getHamletData());

        // Then
        assertTrue(actualTrue);
        assertFalse(actualFalse);
    }

    @Test
    public void testFindHamlet() {
        // When
        boolean actualTrue = hamletParser.findHamlet(hamletParser.getHamletData());

        hamletParser.changeHamletToLeon();
        boolean actualFalse = hamletParser.findHamlet(hamletParser.getHamletData());
        // Then
        assertTrue(actualTrue);
        assertFalse(actualFalse);
    }

    @Test
    public void replaceTest(){
        // Given
        String data = "I wanna do my work at the mill!";
        String original = "mill";
        String replacement = "home";
        String expected = "I wanna do my work at the home!";

        // When
        String actual = hamletParser.replace(original, replacement, data);

        // Then
        assertEquals(expected, actual);
    }
}