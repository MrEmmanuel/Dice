

public class DiceFactory implements SuperClass{

    @Override
    public Die makeDie(int sides) {

        Die die = new Die(sides);
        return die;
    }
}
