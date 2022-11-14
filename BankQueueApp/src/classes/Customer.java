package classes;

public class Customer implements Comparable<Customer> {
    private String name;
    private int priority;

    public Customer(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return name + " (" + priority + ") ";
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public int compareTo(Customer o) {
        return  Integer.compare(priority, o.getPriority());
    }
}
