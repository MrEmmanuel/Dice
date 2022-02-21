public class Main {

    public static void main(String[] args) throws Exception {
        Die die6 = new Die(6);
        die6.roll();

        //Die die20 = new Die(20);
        //die20.roll();
        Die dieDodgy6 = new Die(6,new int[]{1,1,1,1,1,2});
        dieDodgy6.roll();

        Die dieFair6 = new Die(6,new int[]{1,1,1,1,1,1});
        dieFair6.roll();



        System.out.println(die6.value);
        //System.out.println(die20.value);
        System.out.println(dieDodgy6.value);
        System.out.println(dieFair6.value);

       SuperClass die20 = new DiceFactory(20);
       die20.makeDie();

        SuperClass anotherDie20 = new DiceFactory(20);
        anotherDie20.makeDie();

    }
}
