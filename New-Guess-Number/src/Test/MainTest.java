import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

class MainTest {

    Main main;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        main = new Main();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void guess() {
        assertTrue(Main.guess(10,10));
        assertFalse(Main.guess(5,10));
        assertFalse(Main.guess(15,20));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tom","5","Y"})
    void getUserInput(String testValues) {
        ByteArrayInputStream input = new ByteArrayInputStream(testValues.getBytes());
        System.setIn(input);
        if(testValues.equals("Tom")){
            assertEquals(testValues, Main.getUserInput(0));
        }
        else if(testValues.equals("5"))
        {
            assertEquals("5",Main.getUserInput(1));
        }
        else{
            assertEquals("Y", Main.getUserInput(2));
        }
        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"y","Y","n","N"})
    void playAgain(String testValues) {
        ByteArrayInputStream input = new ByteArrayInputStream(testValues.getBytes());
        System.setIn(input);
        if(testValues.equalsIgnoreCase("y"))
            assertTrue(Main.playAgain());
        else
            assertFalse(Main.playAgain());
        System.setIn(System.in);
    }
}