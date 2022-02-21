public class Die {
    int sides;
    int value;

    public Die(int sides){
        this.sides = sides;
    }


    public void roll(){
        value = (int)(Math.random()*sides)+1;
        System.out.println(value);
    }
}
