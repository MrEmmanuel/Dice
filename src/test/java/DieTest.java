
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DieTest {

    Die die;

    @Test
    void rollDie6Test(){
        die = new Die(6);
        int testValue = die.roll();
        assertEquals(testValue, die.value);
    }

    @Test
    void rollDie20Test(){
        die = new Die(20);
        int testValue = die.roll();
        assertEquals(testValue, die.value);
    }

    @Test
    void rollDieProbabilitiesTest(){
        die = new Die(6,new int[]{1,1,1,1,1,2});
        int testValue = die.roll();
        assertEquals(testValue, die.value);
    }
}
