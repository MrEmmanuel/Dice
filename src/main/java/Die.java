import java.util.ArrayList;
import java.util.Random;

public class Die {
    int sides;
    int value;
    ArrayList<Integer> values = new ArrayList<>();

    Die(int sides) {
        this.sides = sides;
        for (int i = 1; i < sides + 1; ++i) {
            values.add(i);
        }
    }
    public Die(int sides, int... array){
        this.sides = sides;
        int sum = 0;
        for (int x : array) {
            if (x != (int)x) {
                throw new IllegalArgumentException("only integer values allowed");
            }
            sum += x;
            if (x < 0) {
                throw new IllegalArgumentException("negative probabilities not allowed");
            }
        }
        if (sum < 1){
            throw new ArithmeticException("probability sum must be greater than 0");
        }
        setProbabilities(sides, array);

    }

    private void setProbabilities(int sides, int[] array) {
        for (int i = 1; i <= sides; ++i) {
            if (i <= array.length && array[i - 1] > 1) {
                for (int j = 0; j < array[i - 1]; ++j) {
                    values.add(i);
                }
                sides = sides + (array[i - 1] - 1);
            } else if (i <= array.length) {
                values.add(i);
            }
        }
        this.sides = sides;
    }


    public int roll(){
        int bound = sides - 1;
        Random random = new Random();
        int randomIndex = random.nextInt(bound);
        value = values.get(randomIndex);
        return value;
    }
}
