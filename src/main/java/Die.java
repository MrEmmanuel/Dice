public class Die {
    int sides;
    int value;
    int[] weighted;
    public Die(int sides, int... array) throws Exception {
        this.sides = sides;
        int sum = 0;

        //this.weighted = array;
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

    }


    public int roll(){
        value = (int)(Math.random()*sides)+1;
        return value;
    }
}
