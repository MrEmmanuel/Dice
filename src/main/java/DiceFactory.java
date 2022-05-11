

public class DiceFactory implements SuperDiceFactory{

    @Override
    public Die makeDie(int sides) {

        Die die = new Die(sides);
        return die;
    }
}
