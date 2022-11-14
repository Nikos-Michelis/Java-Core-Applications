package classes;

import java.util.*;

public class Bank{
    private ArrayList<PriorityQueue<Customer>> cashDesks;

    public Bank(int N) {
        cashDesks = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            cashDesks.add(new PriorityQueue<>());
        }
    }
    public void customerEnters(String fullName, int priority){
        Random r = new Random();
        int cashDesk = r.nextInt(cashDesks.size());
        cashDesks.get(cashDesk).add(new Customer(fullName, priority ));
        System.out.println(fullName +" (" + priority + ") "+" entered! to bank and served by cash desk " + cashDesk);
    }
    public void customerServed(){
        Random r = new Random();
        ArrayList<Integer> notEmpty = new ArrayList<>();
        for (int i = 0; i < cashDesks.size(); i++)
            if(!cashDesks.get(i).isEmpty())
                notEmpty.add(i);
        if (notEmpty.isEmpty()){
            System.out.println("No customers to served");
        }else{


            int cashDesk = notEmpty.get(r.nextInt(notEmpty.size()));
            Customer customer = cashDesks.get(cashDesk).remove();
            System.out.println("Customer: " + customer + " served by cash desk " + cashDesk);

        }
    }
    @Override
    public String toString() {
        String s = "\n" + "="+"Unserved Customers"+"=" ;


        for(int i = 0; i < cashDesks.size(); i++){
            s+= "\nCashDesk "+ i + ":";
            s+=  cashDesks.get(i).toString();
        }
        s += "\n" + "=".repeat(20) + "\n";

        return s;
    }
}
