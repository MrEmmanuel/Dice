import java.util.ArrayList;
import java.util.Random;

public class Die {
    int sides;
    int value;
    ArrayList<Integer> values = new ArrayList<>();

    Die(int sides) {
        this.sides = sides;
        for (int i = 1; i <= sides; i++) {
            values.add(i);
        }
    }
    public Die(int sides, int... probabilities){
        this.sides = sides;
        int sum = 0;
        if(sides != probabilities.length){
           throw new IllegalArgumentException("the number of sides doesn't match the length of the array of probabilities.");
        }
        for (int x : probabilities) {
            if (x != (int)x) {
                throw new IllegalArgumentException("only integer values allowed");
            }
            if (x <= -1) {
                throw new IllegalArgumentException("negative probabilities not allowed");
            }
            sum += x;
        }

        if (sum < 1){
            throw new IllegalArgumentException("probability sum must be greater than 0");
        }
        setProbabilities(sides, probabilities);

    }

    private void setProbabilities(int sides, int[] probabilities) {
        for (int i = 1; i <= sides; i++) {
            if (i <= probabilities.length && probabilities[i - 1] > 1) {
                for (int j = 0; j < probabilities[i - 1]; j++) {
                    values.add(i);
                }
                sides = sides + (probabilities[i - 1] - 1);
            } else if (i <= probabilities.length) {
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
