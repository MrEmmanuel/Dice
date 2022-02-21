public class Die {
    int sides;
    int value;

    public Die(int sides){
        this.sides = sides;
    }


    public int roll(){
        value = (int)(Math.random()*sides)+1;
        return value;
    }
}
