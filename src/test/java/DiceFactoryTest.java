import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceFactoryTest {

    @Test
    void makeDieTest() {
        DiceFactory die = new DiceFactory();
        Assertions.assertTrue(die.makeDie(6) instanceof Die);
    }
}
