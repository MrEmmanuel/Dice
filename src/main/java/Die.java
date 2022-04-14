import java.util.ArrayList;
public class Die {
    int sides;
    int value;
    int[] probabilities;

    Die(int dieSides, int... dieProbabilities){
        this.sides=dieSides;
        this.probabilities=dieProbabilities;
    }
    public void roll() throws Exception{
        if(sides<=1){
            throw new IllegalArgumentException("sides has to be an integer that is greater than one");
        }

        if(sides==probabilities.length) {
            int probabilitySum = 0;
            for (int number : probabilities) {
                if(number == 0){continue;}
                if(number == (int)number) {
                    probabilitySum += number;
                }else {
                    throw new IllegalArgumentException("only integer values allowed");
                }
            }
            if(probabilitySum<=0) {
                throw new IllegalArgumentException("probability sum must be greater than 0");
            }
            ArrayList<Double> probabilitiesInFraction = new ArrayList<>();
            for (int index = 0; index < probabilities.length; index++){
                int currentValue = probabilities[index];
                if(currentValue<0){
                    throw new IllegalArgumentException("negative probabilities not allowed");
                }
                if(index>0){
                    probabilitiesInFraction.add(((double)currentValue)/probabilitySum+probabilitiesInFraction.get(index-1));
                }else {
                    probabilitiesInFraction.add(((double)currentValue)/probabilitySum);
                }
            }
            double random = Math.random();
            ArrayList<Integer> values = new ArrayList<>();
            for(int a=1;a<=sides;a++){
                values.add(a);
            }
            for(int a =0;a<probabilitiesInFraction.size();a++){
                if(random<probabilitiesInFraction.get(a)){
                    value = values.get(a);
                    break;
                }
            }
        }else {
            value = (int) (Math.random()*sides+1);
        }
    }
    public int[] setProbabilities(int... newProbability){
        probabilities = newProbability;
        return newProbability;
    }
}
