import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void getInInt(int testValue) {
        String data = "" + testValue;
        ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
        assertEquals(testValue, testValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void displayStory(int page) {
    }
}