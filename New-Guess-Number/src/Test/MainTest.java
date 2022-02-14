import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void guess() {
        assertTrue(Main.guess(Main.secretNum));
        assertFalse(Main.guess(Main.secretNum-1));
        assertFalse(Main.guess(Main.secretNum+1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tom","5","Y"})
    void getUserInput(String testValues) {
        ByteArrayInputStream input = new ByteArrayInputStream(testValues.getBytes());
        System.setIn(input);
        assertEquals(testValues, Main.getUserInput());
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

    @Test
    //does this generate a new random number
    void generateRand() {
        int temp = main.secretNum;
        main.generateRand();
        assertNotEquals(temp, Main.secretNum);
    }

    @Test
    void setName(){
        ByteArrayInputStream input = new ByteArrayInputStream("Tom".getBytes());
        System.setIn(input);
        main.setName();
        assertEquals("Tom", main.userName);
    }

    @Test
    void reset(){
        int testNum = main.secretNum;
        main.guessNumber = 42;
        main.reset();
        assertEquals(0,main.guessNumber);
        assertNotEquals(testNum, main.secretNum);
    }
}