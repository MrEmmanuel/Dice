import java.util.ArrayList;

public class DiceFactory implements SuperClass{
    ArrayList<Integer> values = new ArrayList<>();
    int sides;

    DiceFactory(int sides) {
        this.sides = sides;
    }

    @Override
    public void makeDie() {
        for (int i = 1; i <= sides; ++i) {
            values.add(i);
        }
    }
}
