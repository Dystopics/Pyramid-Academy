import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


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
        if(page == 0)
            assertEquals("You are in a land full of dragons. In front of you,\n you see two caves. In one cave, the dragon is friendly\n and will share his treasure with you. The other dragon\n is greedy and hungry and will eat you on sight.\n Which cave will you go into? (1 or 2)", Main.displayStory(page));
        else if(page == 1)
            assertEquals("You approach the cave...\n It is dark and spooky...\n A large dragon jumps out in front of you! He opens his jaws and...\n Gobbles you down in one bite!",Main.displayStory(page));
        else if(page == 2)
            assertEquals("You approach the cave...\n It is dark and spooky...\n You light a torch to see better...\n The Cave is empty", Main.displayStory(page));
    }
}