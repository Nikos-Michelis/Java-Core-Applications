import classes.Bank;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(3);
        Random r = new Random();

        for(int i = 0; i < 100; i++){
            if(r.nextInt(100)<70){
                bank.customerEnters("customer: "+ i,1 + r.nextInt(5));
            }else{
                bank.customerServed();
            }
            if(i % 10 == 0)
                System.out.println(bank);
        }
    }
}
