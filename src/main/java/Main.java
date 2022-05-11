public class Main {

    public static void main(String[] args) throws Exception {
        Die die6 = new Die(6);
        die6.roll();

        Die die20 = new Die(20);
        die20.roll();
        
        Die dieDodgy6 = new Die(6,new int[]{0, 0, 0, 1, 0, 0});
        dieDodgy6.roll();

        System.out.println(die6.value);
        System.out.println(die20.value);
        System.out.println(dieDodgy6.value);

    }
}
