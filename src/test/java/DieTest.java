
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DieTest {
    Die die6;
    Die die20;
    @Test
    void sidesDieTest(){
        die6 = new Die(6);
        die20 = new Die(20);
        assertAll(
                () -> assertEquals(die6.sides,6),
                () -> assertEquals(die20.sides,20)
        );
    }

    @Test
    void numberOfSidesTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Die die1 = new Die(1);
            die1.roll();
        }, "sides has to be an integer that is greater than one");
        Assertions.assertEquals("sides has to be an integer that is greater than one", thrown.getMessage());

    }

    @Test
    void sumOfProbabilitiesTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            die6 = new Die(6,new int[]{0,0,0,0,0,0});
            die6.roll();
        }, "probability sum must be greater than 0");
        Assertions.assertEquals("probability sum must be greater than 0", thrown.getMessage());

    }


    @Test
    void probabilitiesHasNegetiveNumberTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           die6 = new Die(6,new int[]{-1,-1,1,1,1,2});
           die6.roll();
        }, "negative probabilities not allowed");
        Assertions.assertEquals("negative probabilities not allowed", thrown.getMessage());

    }

    @Test
    void rollDieProbabilitiesTest() throws Exception {

        die6 = new Die(6,new int[]{0,0,0,1,0,0});
        die6.roll();
        assertEquals(4, die6.value);
    }
}
