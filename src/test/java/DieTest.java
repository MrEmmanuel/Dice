
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
    void rollDieTest(){
        die6 = new Die(6);
        die20 = new Die(20);
        assertAll(
                () -> assertEquals(die6.roll(),die6.value),
                () -> assertEquals(die20.roll(),die20.value)
        );
    }

    @Test
    void numberOfSidesAndLengthOfArrayTest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            die6 = new Die(7,new int[]{1,-1,1,1,1,2});
        }, "the number of sides doesn't match the length of the array of probabilities.");
        Assertions.assertEquals("the number of sides doesn't match the length of the array of probabilities.", thrown.getMessage());

    }

    @Test
    void probabilitiesHasNegetiveNumbertest() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           die6 = new Die(6,new int[]{-1,-1,1,1,1,2});
        }, "negative probabilities not allowed");
        Assertions.assertEquals("negative probabilities not allowed", thrown.getMessage());

    }
    
    @Test
    void rollDieProbabilitiesTest(){
        die6 = new Die(6,new int[]{1,0,0,0,0,0});
        int testValue = die6.roll();
        assertEquals(testValue, die6.value);
    }
}
