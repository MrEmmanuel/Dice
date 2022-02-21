public class Main {

    public static void main(String[] args){
        Die die6 = new Die(6);
        die6.roll();

        Die die20 = new Die(20);
        die20.roll();
        
        System.out.println(die6.value);
        System.out.println(die20.value);

    }
}
